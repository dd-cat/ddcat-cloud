package com.ddcat.entity.role;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author dd-cat
 */
@Data
public class RoleDTO {

    private Long id;
    /**
     * 角色名称
     */
    @Length(max = 20, message = "账户长度为[1-20]")
    @NotBlank(message = "名称必填")
    private String name;
    /**
     * 角色编码
     */
    @Length(max = 20, message = "编码长度为[1-20]")
    @NotBlank(message = "编码必填")
    private String code;
    /**
     * 角色描述
     */
    private String remark;
    /**
     * 许可
     */
    private long[] menuIds;
}
