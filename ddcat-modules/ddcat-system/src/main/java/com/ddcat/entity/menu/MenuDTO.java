package com.ddcat.entity.menu;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author dd-cat
 */
@Data
public class MenuDTO {

    private Long id;
    /**
     * 父节点ID
     */
    private Long parentId;
    /**
     * 名称
     */
    @NotBlank(message = "名称必填")
    private String name;
    /**
     * 类型 0:菜单 1:权限
     */
    @NotNull(message = "类型必填")
    private Byte type;
    /**
     * 菜单 type为0时使用
     */
    private String url;
    /**
     * 权限编码 type为1时使用
     */
    private String code;
    /**
     * 图标 type为0时使用
     */
    private String icon;
}
