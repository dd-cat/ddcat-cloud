package com.ddcat.security.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ddcat.security.entity.UserBean;
import com.ddcat.security.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 填充数据
 *
 * @author dd-cat
 */
@Slf4j
@Component
public class DefaultMetaObjectHandler implements MetaObjectHandler {

    private static final String CREATE_BY = "createBy";
    private static final String CREATE_TIME = "createTime";
    private static final String UPDATE_BY = "updateBy";
    private static final String UPDATE_TIME = "updateTime";
    private static final String FLAG = "flag";

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
        UserBean user = SecurityUtil.getUser();
        this.strictInsertFill(metaObject, CREATE_BY, String.class, user.getUsername());
        this.strictInsertFill(metaObject, FLAG, Byte.class, (byte) 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, UPDATE_BY, String.class, SecurityUtil.getUser().getUsername());
    }


}
