package com.ddcat.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddcat.api.entity.SysRole;
import com.ddcat.system.mapper.SysRoleMapper;
import com.ddcat.system.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dd-cat
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    /**
     * 通过用户ID，查询角色信息
     *
     * @param userId 用户id
     * @return List<SysRole>
     */
    @Override
    public List<SysRole> findRolesByUserId(Long userId) {
        return baseMapper.listRolesByUserId(userId);
    }

}
