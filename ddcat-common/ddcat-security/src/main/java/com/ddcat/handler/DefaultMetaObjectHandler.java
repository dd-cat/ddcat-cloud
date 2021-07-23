package com.ddcat.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
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

    private static final String CREATE_USER_ID = "createUserId";
    private static final String CREATE_TIME = "createTime";
    private static final String UPDATE_USER_ID = "updateUserId";
    private static final String UPDATE_TIME = "updateTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, CREATE_USER_ID, Long.class, 0L);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, UPDATE_USER_ID, Long.class, 0L);
    }


}
