package com.ddcat.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ddcat.core.entiry.BaseEntity;
import lombok.Data;

/**
 * @author dd-cat
 */
@Data
@TableName("sys_role")
public class SysRole extends BaseEntity {

    /**
     * 角色code
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 描述
     */
    private String remark;
}
