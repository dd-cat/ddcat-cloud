package com.ddcat.entity.user;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author dd-cat
 */
@Data
public class UserImportVO {
    /**
     * 账户
     */
    @Excel(name = "账号")
    private String account;
    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;
    /**
     * 性别 0:男 1:女
     */
    @Excel(name = "性别", replace = {"男_0", "女_1"})
    private String sex;
    /**
     * 身份证
     */
    @Excel(name = "身份证")
    private String idCard;
    /**
     * 手机号
     */
    @Excel(name = "手机号")
    private String mobile;
    /**
     * 个人简介
     */
    @Excel(name = "个人简介")
    private String remark;
}
