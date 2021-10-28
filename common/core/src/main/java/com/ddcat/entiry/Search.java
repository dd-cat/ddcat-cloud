package com.ddcat.entiry;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 搜索封装类
 *
 * @author dd-cat
 */
@Data
public class Search implements Serializable {

    /**
     * 编号
     */
    private Long id;

    /**
     * ids
     */
    private List<Integer> ids;

    /**
     * 关键词
     */
    private String keyword;

    /**
     * 搜索字段
     */
    private String searchField;

    /**
     * 搜索值
     */
    private String searchValue;

    /**
     * 开始日期
     */
    private String beginTime;

    /**
     * 结束日期
     */
    private String endTime;

    /**
     * 当前页
     */
    private Integer current;

    /**
     * 页大小
     */
    private Integer size;

    /**
     * 导出最大条数，默认1000
     */
    private Integer exportSize;

    /**
     * 排序属性
     */
    private String prop;

    /**
     * 排序方式：asc,desc
     */
    private String order;
}
