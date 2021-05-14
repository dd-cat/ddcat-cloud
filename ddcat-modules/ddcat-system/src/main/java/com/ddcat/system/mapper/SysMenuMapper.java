package com.ddcat.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddcat.api.entity.SysMenu;

import java.util.List;

/**
 * @author dd-cat
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 获取角色权限
     *
     * @param list /
     * @return /
     */
    List<String> getPermissionsByRoleIds(List<Long> list);
}
