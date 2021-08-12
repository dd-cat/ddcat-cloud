package com.ddcat.entity;

import com.ddcat.entiry.BaseEntity;
import lombok.Data;

/**
 * 用户角色关联表
 *
 * @author dd-cat
 */
@Data
public class SysUserRole extends BaseEntity {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 角色ID
     */
    private Long roleId;
}
