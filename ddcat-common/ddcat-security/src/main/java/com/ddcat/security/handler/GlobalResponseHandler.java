package com.ddcat.security.handler;

import com.ddcat.core.entiry.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 全局统一响应处理
 *
 * @author dd-cat
 * @version 1.0
 * @date 2020-11-25 13:33
 */
@RestControllerAdvice({"com.ddcat.system.controller"})
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {
    /**
     * 进行一些逻辑判断是否需要进行后续的beforeBodyWrite的方法
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    /**
     * 进行一些返回处理
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //如果已经是Result类型直接返回
        if (o instanceof Result) {
            return o;
        }//如果是boolean类型 ture是成功 false失败
        if (o instanceof Boolean) {
            return Result.condition((Boolean) o);
        }
        if (o instanceof Integer) {
            return Result.condition((Integer) o);
        }
        // String 返回会报错
        if (o instanceof String) {
            return Result.success((String) o);
        }
        //其它类型直接返回成功
        return Result.success(o);
    }
}
