package com.ddcat.core.listener;

import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author dd-cat
 */
@Component
@Slf4j
public class DataBaseAuditListener {
    /**
     * 新增数据时，填充创建人和创建时间
     */
    @PrePersist
    public void prePersist(Object object)
            throws IllegalArgumentException, IllegalAccessException {
        // 如果填充字段被分装在一个父类中： Class<?> aClass = object.getClass().getSuperclass();
        Class<?> aClass = object.getClass();
        try {
            // 填充创建用户Id
            addUserId(object, aClass, "createUserId");
            // 填充创建时间
            addOperateTime(object, aClass, "createTime");
        } catch (NoSuchFieldException e) {
            log.error("反射获取属性异常：", e);
        }


    }

    /**
     * 更新数据时，填充更新人和更新时间
     */
    @PreUpdate
    public void preUpdate(Object object)
            throws IllegalArgumentException, IllegalAccessException {
        Class<?> aClass = object.getClass();
        try {
            // 填充更新用户Id
            addUserId(object, aClass, "updateUserId");
            // 填充更新时间
            addOperateTime(object, aClass, "updateTime");
        } catch (NoSuchFieldException e) {
            log.error("反射获取属性异常：", e);
        }
    }


    /**
     * 新增数据之后的操作
     */
    @PostPersist
    public void postPersist(Object object)
            throws IllegalArgumentException, IllegalAccessException {

    }

    /**
     * 更新数据之后的操作
     */
    @PostUpdate
    public void postUpdate(Object object)
            throws IllegalArgumentException, IllegalAccessException {
    }

    /**
     * 填充用户id
     *
     * @param object
     * @param aClass
     * @param propertyName 属性名（对应实体类中的属性）
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    protected void addUserId(Object object, Class<?> aClass, String propertyName) throws NoSuchFieldException, IllegalAccessException {
        Field userId = aClass.getDeclaredField(propertyName);
        userId.setAccessible(true);
        // 获取userId值
        Object userIdValue = userId.get(object);
        if (userIdValue == null) {
            // 在此处使用当前用户id或默认用户id
            Integer id = Integer.valueOf((String) StpUtil.getLoginId());
            userId.set(object, id);
        }
    }

    /**
     * 填充操作时间
     *
     * @param object
     * @param aClass
     * @param propertyName 属性名（对应实体类中的属性）
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    protected void addOperateTime(Object object, Class<?> aClass, String propertyName) throws NoSuchFieldException, IllegalAccessException {
        Field time = aClass.getDeclaredField(propertyName);
        time.setAccessible(true);
        // 获取time值
        Object createdTimeValue = time.get(object);
        if (createdTimeValue == null) {
            // 使用当前时间进行填充
            time.set(object, new Date());
        }
    }

}

