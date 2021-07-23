package com.ddcat.entity.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author dd-cat
 */
@Data
public class UserLoginDTO {
    /**
     * 账号 可以是手机号、账号等
     */
    @NotBlank(message = "账号必填")
    private String key;
    /**
     * 密码
     */
    @NotBlank(message = "密码必填")
    private String password;
}
