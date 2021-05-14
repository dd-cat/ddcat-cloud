package com.ddcat.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ddcat.core.entiry.BaseEntity;
import lombok.Data;

/**
 * @author 小懒虫
 * @date 2018/8/14
 */
@Data
@TableName("sys_menu")
public class SysMenu extends BaseEntity {
    private String title;
    private Long pid;

    private String url;
    private String permission;
    private String icon;
    private Byte type;
    private Integer sort;
    private String remark;
}
