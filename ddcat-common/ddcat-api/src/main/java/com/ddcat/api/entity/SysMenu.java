package com.ddcat.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

/**
 * @author 小懒虫
 * @date 2018/8/14
 */
@Data
@TableName("sys_menu")
public class SysMenu implements Serializable {
    @TableId
    private Long id;
    private Long pid;
    private String pids;
    private String title;
    private String url;
    private String perms;
    private String icon;
    private Byte type;
    private Integer sort;
    private String remark;

    private Date createDate;
    private Date updateDate;

    private Byte status;

}
