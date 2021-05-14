package com.ddcat.system.api;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ddcat.api.entity.SysUser;
import com.ddcat.api.entity.UserInfo;
import com.ddcat.api.service.UserService;
import com.ddcat.system.mapper.SysMenuMapper;
import com.ddcat.system.mapper.SysRoleMapper;
import com.ddcat.system.mapper.SysUserMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author dd-cat
 */
@DubboService
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public UserInfo info(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.selectOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));
        if (sysUser == null) {
            throw new UsernameNotFoundException(username + "用户不存在");
        }
        System.out.println("sysUser:" + sysUser);
        //获取用户角色
        List<Long> roleIds = sysRoleMapper.getRoleIdByUserId(sysUser.getId());
        System.out.println("roleIds:" + roleIds);
        //获取角色权限
        List<String> permissions = sysMenuMapper.getPermissionsByRoleIds(roleIds);
        System.out.println(permissions.size());
        return new UserInfo(sysUser, roleIds, permissions);
    }
}
