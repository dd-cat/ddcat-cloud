package com.ddcat.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ddcat.core.entiry.BaseEntity;
import lombok.Data;

/**
 * @author dd-cat
 */
@Data
@TableName("sys_menu")
public class SysMenu extends BaseEntity {
    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单权限标识
     */
    private String permission;

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 前端路由标识路径
     */
    private String path;

    /**
     * 排序值
     */
    private Integer sort;

    /**
     * 菜单类型 （0菜单 1按钮）
     */
    private String type;

    /**
     * 路由缓冲
     */
    private String isCache;

    /**
     * 是否外链
     */
    private String isFrame;

    /**
     * 显示状态
     */
    private String visible;

    /**
     * VUE页面
     */
    private String component;
}
