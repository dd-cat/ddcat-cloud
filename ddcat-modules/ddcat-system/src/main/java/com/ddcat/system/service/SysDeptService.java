package com.ddcat.system.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ddcat.api.entity.SysDept;

import java.util.List;
import java.util.Set;

/**
 * @author dd-cat
 */
public interface SysDeptService extends IService<SysDept> {

    /**
     * 部门树
     *
     * @param all 部门信息
     * @return 部门树
     */
    List<Tree<Long>> treeDept(Set<SysDept> all);
}
