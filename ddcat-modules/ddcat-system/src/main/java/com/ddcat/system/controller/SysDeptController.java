package com.ddcat.system.controller;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ddcat.api.entity.SysDept;
import com.ddcat.system.service.SysDeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dd-cat
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/dept")
public class SysDeptController {
    private final SysDeptService deptService;

    /**
     * 部门树
     *
     * @return 部门信息
     */
    @GetMapping("tree")
    public List<Tree<Long>> tree() {
        Set<SysDept> all = new HashSet<>(deptService.list());
        return deptService.treeDept(all);
    }

    @GetMapping("list")
    public List<SysDept> list(SysDept dept) {
        return deptService.list(Wrappers.query(dept));
    }

    /**
     * 通过ID查询
     *
     * @param id ID
     */
    @GetMapping("/{id}")
    public SysDept getById(@PathVariable Integer id) {
        return deptService.getById(id);
    }

    /**
     * 添加
     *
     * @param sysDept 实体
     */
    @PostMapping
    public boolean save(@RequestBody SysDept sysDept) {
        return deptService.save(sysDept);
    }

    /**
     * 删除
     *
     * @param ids ids
     */
    @DeleteMapping("/{ids}")
    public boolean removeByIds(@PathVariable List<Long> ids) {
        return deptService.removeByIds(ids);
    }

    /**
     * 编辑
     *
     * @param sysDept 实体
     */
    @PutMapping
    public boolean update(@RequestBody SysDept sysDept) {
        return deptService.updateById(sysDept);
    }
}
