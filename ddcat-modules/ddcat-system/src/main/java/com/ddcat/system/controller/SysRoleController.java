package com.ddcat.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddcat.api.entity.SysRole;
import com.ddcat.core.annotation.SysLog;
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


    /**
     * 角色列表分页
     *
     * @param page 分页信息
     * @param role /
     * @return /
     */
    @GetMapping("page")
    @SysLog("角色列表分页")
    public IPage<SysRole> list(Page<SysRole> page, SysRole role) {
        return roleService.page(page, Wrappers.query(role));
    }

    /**
     * 通过ID查询
     *
     * @param id ID
     */
    @GetMapping("/{id}")
    @SysLog("通过ID查询角色")
    public SysRole getById(@PathVariable Integer id) {
        return roleService.getById(id);
    }

    /**
     * 添加
     *
     * @param role 实体
     */
    @PostMapping
    @SysLog("添加角色")
    public boolean save(@RequestBody SysRole role) {
        return roleService.save(role);
    }

    /**
     * 删除
     *
     * @param ids ids
     */
    @DeleteMapping("/{ids}")
    @SysLog("删除角色")
    public boolean removeByIds(@PathVariable List<Long> ids) {
        return roleService.removeByIds(ids);
    }

    /**
     * 编辑
     *
     * @param sysRole 实体
     */
    @PutMapping
    @SysLog("编辑角色")
    public boolean update(@RequestBody SysRole sysRole) {
        return roleService.updateById(sysRole);
    }

}
