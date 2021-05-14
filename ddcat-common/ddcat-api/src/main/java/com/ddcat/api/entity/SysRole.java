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

    private String name;
    private String title;
    private String remark;
}
