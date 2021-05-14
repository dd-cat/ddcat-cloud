package com.ddcat.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ddcat.core.entiry.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author dd-cat
 */
@Data
@TableName("sys_user")
public class SysUser extends BaseEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 上次登陆IP
     */
    private String loginIp;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String remark;

    /**
     * 部门ID
     */
    private Long deptId;

}

