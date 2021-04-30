package com.ddcat.entiry;

import com.ddcat.constant.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author dd-cat
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     */
    private int code;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 时间戳
     */
    private long time;

    /**
     * 业务数据
     */
    private T data;

    public static <T> Result<T> success() {
        return restResult(null, Constants.SUCCESS, Constants.DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> success(T data) {
        return restResult(data, Constants.SUCCESS, Constants.DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> success(T data, String msg) {
        return restResult(data, Constants.SUCCESS, msg);
    }

    public static <T> Result<T> fail() {
        return restResult(null, Constants.FAIL, Constants.DEFAULT_FAIL_MESSAGE);
    }

    public static <T> Result<T> fail(String msg) {
        return restResult(null, Constants.FAIL, msg);
    }

    public static <T> Result<T> fail(T data) {
        return restResult(data, Constants.FAIL, Constants.DEFAULT_FAIL_MESSAGE);
    }

    public static <T> Result<T> fail(T data, String msg) {
        return restResult(data, Constants.FAIL, msg);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return restResult(null, code, msg);
    }

    private static <T> Result<T> restResult(T data, int code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        apiResult.setTime(System.currentTimeMillis());
        return apiResult;
    }

    public static <T> Result<T> condition(boolean flag) {
        return flag ? success() : fail();
    }

    public static <T> Result<T> condition(int rows) {
        return rows > 0 ? success() : fail();
    }

}
