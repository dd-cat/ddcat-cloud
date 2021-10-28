package com.ddcat.entity;

import com.ddcat.entiry.BaseEntity;
import lombok.Data;

/**
 * 用户
 *
 * @author dd-cat
 */
@Data
public class SysUser extends BaseEntity {
    /**
     * 账户
     */
    private String account;
    /**
     * 用户名
     */
    private String username;
    /**
     * 性别 0:男 1:女
     */
    private Byte sex;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 所属机构
     */
    private Long deptId;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 个人简介
     */
    private String remark;
    /**
     * 密码
     */
    private String password;
}
