package com.ddcat.service;

import com.ddcat.entity.SysLog;

/**
 * 用户Dubbo接口
 *
 * @author dd-cat
 */
public interface RemoteLogService {

    /**
     * 添加系统日志
     *
     * @param sysLog /
     * @throws Exception /
     */
    void saveLog(SysLog sysLog) throws Exception;
}
