package com.ddcat.entity;

import com.ddcat.entiry.BaseEntity;
import lombok.Data;

/**
 * 字典项
 *
 * @author dd-cat
 */
@Data
public class SysDictItem extends BaseEntity {
    /**
     * 名称
     */
    private String name;
    /**
     * 类型
     */
    private String type;
    /**
     * 值
     */
    private String value;
    /**
     * 排序
     */
    private String sort;
}
