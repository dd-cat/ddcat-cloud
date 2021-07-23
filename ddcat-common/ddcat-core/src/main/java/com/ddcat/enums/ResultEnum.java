package com.ddcat.enums;

import lombok.Getter;

/**
 * @author dd-cat
 */
@Getter
public enum ResultEnum {
    SUCCESS(0, "成功!"),
    FAIL(1, "失败!"),
    PARAMETER_ERROR(2, "参数错误"),

    //系统模块
    S000001(1_1_1, "用户不存在！"),
    S000002(1_1_2, "密码输入错误！"),

    //业务模块
    B000001(1_2_1, "手机号为空！"),
    B000002(1_2_2, "不能删除自己！"),
    B000003(1_2_3, "账号已存在！"),
    B000004(1_2_4, "身份信息不合法！"),
    B000005(1_2_5, "旧密码输入不正确！"),
    B000006(1_2_6, "角色已存在！"),
    B000007(1_2_7, "字典编码重复！"),
    B000008(1_2_8, "字典项名称或值重复！"),
    B000009(1_2_9, "部门编号重复！"),
    B000010(1_2_10, "删除部门存在下级部门,不能删除！"),
    B000011(1_2_11, "删除部门下存在用户,不能删除！"),
    B000012(1_2_12, "已有用户关联此角色，不能删除！"),
    ;

    private final long code;
    private final String message;

    ResultEnum(long code, String message) {
        this.code = code;
        this.message = message;
    }
}
