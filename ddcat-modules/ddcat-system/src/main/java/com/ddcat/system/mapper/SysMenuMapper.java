package com.ddcat.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddcat.api.entity.SysMenu;

import java.util.List;

/**
 * @author dd-cat
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 通过角色编号查询菜单
     *
     * @param roleId 角色ID
     * @return List<SysMenu>
     */
    List<SysMenu> listMenusByRoleId(Long roleId);
}
