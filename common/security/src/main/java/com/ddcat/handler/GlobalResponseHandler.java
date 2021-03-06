package com.ddcat.handler;

import com.ddcat.entiry.Result;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;

/**
 * 全局统一响应处理
 *
 * @author dd-cat
 */
@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {
    private static final Class<? extends Annotation> ANNOTATION_TYPE = ResponseBody.class;

    /**
     * 判断类或者方法是否使用@ResponseBody
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return AnnotatedElementUtils.hasAnnotation(methodParameter
                .getContainingClass(), ANNOTATION_TYPE)
                || methodParameter.hasMethodAnnotation(ANNOTATION_TYPE);
    }

    /**
     * 当类或者方法已使用@ResponseBody时 会调用此方法
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter parameter, MediaType type
            , Class<? extends HttpMessageConverter<?>> aClass
            , ServerHttpRequest request, ServerHttpResponse response) {
        return o instanceof Result ? o : Result.success(o);
    }
}
