package com.ddcat.entiry;

import com.ddcat.enums.ResultEnum;
import lombok.Data;

/**
 * 响应信息主体
 *
 * @author dd-cat
 */
@Data
public class Result<T> {
    /**
     * 状态码
     */
    private long code;
    /**
     * 消息内容
     */
    private String msg;
    /**
     * 业务数据
     */
    private T data;

    public static <T> Result<T> success(T data) {
        return restResult(data, ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage());
    }

    public static <T> Result<T> fail(long code, String msg) {
        return restResult(null, code, msg);
    }

    private static <T> Result<T> restResult(T data, long code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
