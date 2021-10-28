package com.ddcat.api;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ddcat.entity.SysUser;
import com.ddcat.service.RemoteUserService;
import com.ddcat.service.SysUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dd-cat
 */
@DubboService
public class RemoteUserServiceImpl implements RemoteUserService {
    @Autowired
    private SysUserService sysUserService;

    @Override
    public SysUser info(String username) {
        return sysUserService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));
    }
}
