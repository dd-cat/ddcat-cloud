package com.ddcat.entity.user;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author dd-cat
 */
@Data
public class UserPageVO {
    /**
     * 序号
     */
    private Long id;
    /**
     * 账户
     */
    private String account;
    /**
     * 姓名
     */
    private String username;
    /**
     * 所属机构
     */
    private String deptName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
