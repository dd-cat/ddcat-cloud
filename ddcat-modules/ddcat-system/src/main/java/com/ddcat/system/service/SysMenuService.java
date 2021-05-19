package com.ddcat.system.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ddcat.api.entity.SysMenu;

import java.util.List;
import java.util.Set;

/**
 * @author dd-cat
 */
public interface SysMenuService extends IService<SysMenu> {
    /**
     * 通过角色编号查询URL 权限
     *
     * @param roleId 角色ID
     * @return 菜单列表
     */
    List<SysMenu> findMenuByRoleId(Long roleId);

    /**
     * 查询菜单
     *
     * @param sysMenus /
     * @return /
     */
    List<Tree<Long>> treeMenu(Set<SysMenu> sysMenus);
}
