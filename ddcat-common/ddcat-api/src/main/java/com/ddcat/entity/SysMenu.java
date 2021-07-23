package com.ddcat.entity;

import com.ddcat.entiry.BaseEntity;
import lombok.Data;

/**
 * 许可
 *
 * @author dd-cat
 */
@Data
public class SysMenu extends BaseEntity {
    /**
     * 父节点ID
     */
    private Long parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * VUE页面
     */
    private String component;
    /**
     * 0:菜单 1:权限
     */
    private Byte type;
    /**
     * 菜单 type为0时使用
     */
    private String path;
    /**
     * 权限编码 type为1时使用
     */
    private String permission;
    /**
     * 图标 type为0时使用
     */
    private String icon;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 菜单描述
     */
    private String remark;
}
