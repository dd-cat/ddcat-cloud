package com.ddcat.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author dd-cat
 */
public interface SupperMapper<T> extends BaseMapper<T> {
    /**
     * 逻辑删除并填充字段
     *
     * @param entity 实体对象
     * @return /
     */
    int deleteByIdWithFill(T entity);
}
