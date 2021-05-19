package com.ddcat.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddcat.api.entity.SysRole;
import com.ddcat.system.service.SysRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dd-cat
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class SysRoleController {
    private final SysRoleService roleService;


    @GetMapping("page")
    public IPage<SysRole> list(Page<SysRole> page, SysRole role) {
        return roleService.page(page, Wrappers.query(role));
    }

    @GetMapping("list")
    public List<SysRole> list(SysRole role) {
        return roleService.list(Wrappers.query(role));
    }

    /**
     * 通过ID查询
     *
     * @param id ID
     */
    @GetMapping("/{id}")
    public SysRole getById(@PathVariable Integer id) {
        return roleService.getById(id);
    }

    /**
     * 添加
     *
     * @param role 实体
     */
    @PostMapping
    public boolean save(@RequestBody SysRole role) {
        return roleService.save(role);
    }

    /**
     * 删除
     *
     * @param ids ids
     */
    @DeleteMapping("/{ids}")
    public boolean removeByIds(@PathVariable List<Long> ids) {
        return roleService.removeByIds(ids);
    }

    /**
     * 编辑
     *
     * @param sysRole 实体
     */
    @PutMapping
    public boolean update(@RequestBody SysRole sysRole) {
        return roleService.updateById(sysRole);
    }

}
