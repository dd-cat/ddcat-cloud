package com.ddcat.service;

import com.ddcat.entity.SysLog;

/**
 * @author dd-cat
 */
public interface SysLogService {
    /**
     * 添加系统日志
     *
     * @param log -
     */
    void save(SysLog log);
}
