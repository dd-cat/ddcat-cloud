package com.ddcat.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddcat.api.entity.SysUser;
import com.ddcat.system.mapper.SysUserMapper;
import com.ddcat.system.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @author dd-cat
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements SysUserService {

}
