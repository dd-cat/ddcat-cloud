package com.ddcat.system.controller;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ddcat.api.entity.SysMenu;
import com.ddcat.core.annotation.SysLog;
import com.ddcat.security.entity.UserBean;
import com.ddcat.security.util.SecurityUtil;
import com.ddcat.system.service.SysMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dd-cat
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class SysMenuController {
    private final SysMenuService menuService;

    /**
     * 菜单树
     *
     * @param menu 菜单
     * @return /
     */
    @GetMapping("tree")
    @SysLog("菜单树")
    public List<Tree<Long>> tree(SysMenu menu) {
        Set<SysMenu> all = new HashSet<>(menuService.list(Wrappers.query(menu)));
        return menuService.treeMenu(all);
    }

    /**
     * 当前登录人菜单信息
     *
     * @return /
     */
    @GetMapping
    @SysLog("当前登录人菜单信息")
    public List<Tree<Long>> getUserMenus() {
        Set<SysMenu> all = new HashSet<>();
        UserBean user = SecurityUtil.getUser();
        user.getRoles().forEach(roleId ->
                all.addAll(
                        menuService.findMenuByRoleId(roleId).stream()
                                .filter(menu -> !"2".equals(menu.getType()))
                                .collect(Collectors.toList())
                )
        );
        return menuService.treeMenu(all);
    }

    /**
     * 通过角色ID查询菜单
     *
     * @param roleId ID
     */
    @GetMapping("/roleMenuTreeSelect/{roleId}")
    @SysLog("通过角色ID查询菜单")
    public List<Long> findMenuByRoleId(@PathVariable Long roleId) {
        return menuService.findMenuByRoleId(roleId).stream().map(SysMenu::getId).collect(Collectors.toList());
    }

    /**
     * 通过ID查询
     *
     * @param id ID
     */
    @GetMapping("/{id}")
    @SysLog("通过ID查询菜单")
    public SysMenu getById(@PathVariable Integer id) {
        return menuService.getById(id);
    }

    /**
     * 添加
     *
     * @param menu 实体
     */
    @PostMapping
    @SysLog("添加菜单")
    public boolean save(@RequestBody SysMenu menu) {
        return menuService.save(menu);
    }

    /**
     * 删除
     *
     * @param ids ids
     */
    @DeleteMapping("/{ids}")
    @SysLog("删除菜单")
    public boolean removeByIds(@PathVariable List<Long> ids) {
        return menuService.removeByIds(ids);
    }

    /**
     * 编辑
     *
     * @param sysMenu 实体
     */
    @PutMapping
    @SysLog("更新菜单")
    public boolean update(@RequestBody SysMenu sysMenu) {
        return menuService.updateById(sysMenu);
    }
}
