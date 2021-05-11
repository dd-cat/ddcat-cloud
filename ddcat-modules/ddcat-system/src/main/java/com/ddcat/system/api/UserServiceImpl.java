package com.ddcat.system.api;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ddcat.api.entity.SysUser;
import com.ddcat.api.entity.UserInfo;
import com.ddcat.api.service.UserService;
import com.ddcat.system.mapper.SysUserMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dd-cat
 */
@DubboService
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserInfo info(String username) {
        SysUser sysUser = sysUserMapper.selectOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));
        System.out.println("sysUser:" + sysUser);
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(sysUser);
        return new UserInfo(sysUser, new ArrayList<>(), new ArrayList<>());
    }
}
