package com.ddcat.exception;

import com.ddcat.enums.ResultEnum;
import lombok.Getter;

/**
 * 业务异常
 *
 * @author dd-cat
 */
@Getter
public class BusinessException extends RuntimeException {
    private final long code;

    private final String message;

    public BusinessException(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }
}
