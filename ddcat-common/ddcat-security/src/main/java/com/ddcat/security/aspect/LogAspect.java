package com.ddcat.security.aspect;

import cn.hutool.json.JSONUtil;
import com.ddcat.api.entity.SysLog;
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
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();

        SysLog logBean = new SysLog();
        logBean.setMethod(className + "." + methodName + "()");
        logBean.setParams(JSONUtil.toJsonStr(point.getArgs()));
        logBean.setTitle(sysLog.value());

        // 发送异步日志事件
        Long startTime = System.currentTimeMillis();
        Object obj;

        try {
            obj = point.proceed();
        } catch (Exception e) {
            logBean.setException(e.getMessage());
            throw e;
        } finally {
            Long endTime = System.currentTimeMillis();
            logBean.setTime(endTime - startTime);
            remoteLogService.saveLog(logBean);
        }
        return obj;
    }
}
