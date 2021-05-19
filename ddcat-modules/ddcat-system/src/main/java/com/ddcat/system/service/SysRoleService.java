package com.ddcat.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddcat.api.entity.SysRole;

import java.util.List;

/**
 * @author dd-cat
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 通过用户ID，查询角色信息
     *
     * @param userId 用户id
     * @return List<SysRole>
     */
    List<SysRole> findRolesByUserId(Long userId);
}
