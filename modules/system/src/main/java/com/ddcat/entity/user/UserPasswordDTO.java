package com.ddcat.entity.user;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author dd-cat
 */
@Data
public class UserPasswordDTO {
    /**
     * 旧密码
     */
    @NotBlank(message = "旧密码必填")
    @Length(min = 6, max = 20, message = "密码长度为[6-20]")
    private String oldPassword;
    /**
     * 新密码
     */
    @NotBlank(message = "新密码必填")
    @Length(min = 6, max = 20, message = "密码长度为[6-20]")
    private String newPassword;
}
