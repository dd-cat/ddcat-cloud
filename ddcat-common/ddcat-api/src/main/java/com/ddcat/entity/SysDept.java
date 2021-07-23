package com.ddcat.entity;

import com.ddcat.entiry.TreeEntity;
import lombok.Data;

/**
 * 组织机构
 *
 * @author dd-cat
 */
@Data
public class SysDept extends TreeEntity {
    /**
     * 机构编码
     */
    private String code;
    /**
     * 机构LOGO
     */
    private String avatar;
}
