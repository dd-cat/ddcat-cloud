package com.ddcat.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dd-cat
 */
@Data
@TableName("sys_dept")
public class SysDept implements Serializable {
    @TableId
    private Long id;

    /**
     * 部门名称
     */
    private String title;

    /**
     * 父级编号
     */
    private Long pid;

    /**
     * 所有父级编号
     */
    private String pids;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 数据状态
     */
    private Byte status;
}
