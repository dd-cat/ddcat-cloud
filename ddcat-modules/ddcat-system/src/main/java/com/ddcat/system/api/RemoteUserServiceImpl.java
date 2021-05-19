package com.ddcat.system.api;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ddcat.api.entity.SysMenu;
import com.ddcat.api.entity.SysRole;
import com.ddcat.api.entity.SysUser;
import com.ddcat.api.entity.UserInfo;
import com.ddcat.api.service.RemoteUserService;
import com.ddcat.system.service.SysMenuService;
import com.ddcat.system.service.SysRoleService;
import com.ddcat.system.service.SysUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dd-cat
 */
@DubboService
public class RemoteUserServiceImpl implements RemoteUserService {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public UserInfo info(String username) {
        SysUser sysUser = sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));
        Set<String> permissions = new HashSet<>();
        List<Long> roleIds = sysRoleService.findRolesByUserId(sysUser.getId()).stream().map(SysRole::getId)
                .collect(Collectors.toList());
        roleIds.forEach(roleId -> {
            List<String> permissionList = sysMenuService.findMenuByRoleId(roleId).stream()
                    .map(SysMenu::getPermission).filter(StrUtil::isNotEmpty)
                    .collect(Collectors.toList());
            permissions.addAll(permissionList);
        });
        return new UserInfo(sysUser, roleIds, new ArrayList<>(permissions));
    }
}
