package com.ddcat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddcat.entity.SysDept;

import java.util.List;

/**
 * @author dd-cat
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

    /**
     * 获取当前节点下所有节点ID
     *
     * @param deptId 部门ID
     * @return -
     */
    List<Long> selectTreeId(Long deptId);

}
