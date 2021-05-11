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
@TableName("sys_role")
public class SysRole implements Serializable {
    @TableId
    private Long id;
    private String name;
    private String title;
    private String remark;
    private Date createDate;
    private Date updateDate;
    private Byte status;
}
