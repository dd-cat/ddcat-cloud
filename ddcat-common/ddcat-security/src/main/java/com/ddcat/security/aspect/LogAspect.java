package com.ddcat.security.aspect;

import com.ddcat.api.service.RemoteLogService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author dd-cat
 */
@Aspect
@Slf4j
@Component
public class LogAspect {

    @DubboReference(async = true)
    private RemoteLogService remoteLogService;

    @SneakyThrows
    @Around("@annotation(sysLog)")
    public Object around(ProceedingJoinPoint point, com.ddcat.core.annotation.SysLog sysLog) {
        // TODO

        return point.proceed();
    }
}
