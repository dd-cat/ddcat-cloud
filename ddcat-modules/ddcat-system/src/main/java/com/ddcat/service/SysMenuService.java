package com.ddcat.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ddcat.entity.SysMenu;

import java.util.List;
import java.util.Set;

/**
 * @author dd-cat
 */
public interface SysMenuService extends IService<SysMenu> {
    /**
     * 获取树形数据
     *
     * @return -
     */
    List<Tree<Long>> tree(Set<SysMenu> all);

    /**
     * 通过角色ID获取菜单ID
     *
     * @param id -
     * @return -
     */
    List<Long> getByRoleId(long id);

    /**
     * 通过角色编号查询URL 权限
     *
     * @param roleId 角色ID
     * @return -
     */
    List<SysMenu> findMenuByRoleId(Long roleId);

    /**
     * 当前登录人菜单信息
     *
     * @return -
     */
    List<Tree<Long>> getUserMenus();
}
