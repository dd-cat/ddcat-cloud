package com.ddcat.entity.role;

import com.ddcat.entiry.Search;
import lombok.Data;

/**
 * @author dd-cat
 */
@Data
public class RolePageDTO extends Search {
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * 备注
     */
    private String remark;
    /**
     * 排序字段 null:不排序 0:名称 1:编码 2:备注
     */
    private Byte sortField;
    /**
     * 是否升序
     */
    private Boolean isAsc;
}
