package com.ddcat.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ddcat.core.entiry.BaseEntity;
import lombok.Data;

/**
 * 字典表
 *
 * @author dd-cat
 */
@Data
@TableName("sys_dict")
public class SysDict extends BaseEntity {

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String description;

    /**
     * 备注信息
     */
    private String remarks;
}
