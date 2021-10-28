package com.ddcat.entiry;

import lombok.Data;

/**
 * 树基础实体
 *
 * @author dd-cat
 */
@Data
public class TreeEntity extends BaseEntity {
    /**
     * 父节点 ID
     */
    private Long parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 排序
     */
    protected Integer sort;
}
