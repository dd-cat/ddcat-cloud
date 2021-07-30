package com.ddcat.enums;

import lombok.Getter;

/**
 * @author dd-cat
 * 100_100 模块_异常
 */
@Getter
public enum ResultEnum {
    /**
     * 异常
     */
    SUCCESS(0, "成功!"),
    FAIL(1, "失败!"),
    PARAMETER_ERROR(2, "参数错误"),

    //系统模块
    S000001(100_100, "用户不存在！"),
    S000002(100_101, "密码输入错误！"),
    //业务模块
    B000001(200_100, "手机号为空！"),
    B000002(200_101, "不能删除自己！"),
    B000003(200_102, "账号已存在！"),
    B000004(200_103, "身份信息不合法！"),
    B000005(200_104, "旧密码输入不正确！"),
    B000006(200_105, "角色已存在！"),
    B000007(200_106, "字典编码重复！"),
    B000008(200_107, "字典项名称或值重复！"),
    B000009(200_108, "部门编号重复！"),
    B000010(200_109, "删除部门存在下级部门,不能删除！"),
    B000011(200_110, "删除部门下存在用户,不能删除！"),
    B000012(200_111, "已有用户关联此角色，不能删除！");

    private final long code;
    private final String message;

    ResultEnum(long code, String message) {
        this.code = code;
        this.message = message;
    }
}
