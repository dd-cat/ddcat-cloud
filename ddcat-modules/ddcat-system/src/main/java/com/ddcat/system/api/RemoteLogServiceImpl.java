package com.ddcat.system.api;

import com.ddcat.api.entity.SysLog;
import com.ddcat.api.service.RemoteLogService;
import com.ddcat.system.mapper.SysLogMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dd-cat
 */
@DubboService(async = true)
public class RemoteLogServiceImpl implements RemoteLogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void saveLog(SysLog sysLog) {
        sysLogMapper.insert(sysLog);
    }
}
