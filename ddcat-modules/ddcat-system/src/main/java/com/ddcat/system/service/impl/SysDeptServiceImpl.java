package com.ddcat.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddcat.api.entity.SysDept;
import com.ddcat.system.mapper.SysDeptMapper;
import com.ddcat.system.service.SysDeptService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author dd-cat
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Override
    public List<Tree<Long>> treeDept(Set<SysDept> all) {
        List<TreeNode<Long>> nodeList = CollUtil.newArrayList();
        for (SysDept dept : all) {
            TreeNode<Long> treeNode = new TreeNode<>(dept.getId(), dept.getParentId(), dept.getName(), dept.getSort());
            nodeList.add(treeNode);
        }
        return TreeUtil.build(nodeList, 0L);
    }
}
