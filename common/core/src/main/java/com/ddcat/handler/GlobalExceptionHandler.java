package com.ddcat.handler;

import cn.dev33.satoken.exception.NotLoginException;
import com.ddcat.entiry.Result;
import com.ddcat.enums.ResultEnum;
import com.ddcat.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 全局异常处理器
 *
 * @author dd-cat
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 认证异常
     *
     * @param nle -
     * @return -
     */
    @ExceptionHandler(NotLoginException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result<String> handlerNotLoginException(NotLoginException nle) {
        // 打印堆栈，以供调试
        nle.printStackTrace();
        return Result.fail(Long.parseLong(nle.getType()), nle.getMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result<String> businessException(BusinessException e) {
        return Result.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result<String> catchRuntimeException(RuntimeException e) {
        e.printStackTrace();
        return Result.fail(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMessage());
    }

    /**
     * 校验错误拦截处理
     *
     * @param exception 错误信息集合
     * @return 错误信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> handleException(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();
        String message = "";
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            if (!errors.isEmpty()) {
                FieldError fieldError = (FieldError) errors.get(0);
                message = fieldError.getDefaultMessage();
            }
        }
        return Result.fail(ResultEnum.PARAMETER_ERROR.getCode(), "".equals(message) ? "请填写正确信息" : (ResultEnum.PARAMETER_ERROR.getMessage() + message));
    }

    /**
     * 全局异常
     *
     * @param e 异常
     * @return Result
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        e.printStackTrace();
        return Result.fail(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMessage());
    }
}
