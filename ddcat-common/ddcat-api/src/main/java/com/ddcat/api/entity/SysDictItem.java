package com.ddcat.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ddcat.core.entiry.BaseEntity;
import lombok.Data;

/**
 * 字典详情表
 *
 * @author dd-cat
 */
@Data
@TableName("sys_dict_item")
public class SysDictItem extends BaseEntity {

    /**
     * 字典ID
     */
    private Long dictId;

    /**
     * 类型
     */
    private String type;

    /**
     * 标签名
     */
    private String label;

    /**
     * 数据值
     */
    private String value;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序（升序）
     */
    private Integer sort;

    /**
     * 备注信息
     */
    private String remarks;

}

