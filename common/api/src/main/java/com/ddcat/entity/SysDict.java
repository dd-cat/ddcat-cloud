package com.ddcat.entity;

import com.ddcat.entiry.BaseEntity;
import lombok.Data;

/**
 * 字典
 *
 * @author dd-cat
 */
@Data
public class SysDict extends BaseEntity {
    /**
     * 名称
     */
    private String name;
    /**
     * 类型
     */
    private String type;
}
