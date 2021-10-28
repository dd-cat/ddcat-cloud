package com.ddcat.entity;

import com.ddcat.entiry.BaseEntity;
import lombok.Data;

/**
 * 角色菜单关联表
 *
 * @author dd-cat
 */
@Data
public class SysRoleMenu extends BaseEntity {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;
}
