package com.ddcat.service;

import com.ddcat.entity.SecurityUser;
import com.ddcat.entity.SysUser;
import lombok.SneakyThrows;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author dd-cat
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @DubboReference
    private RemoteUserService remoteUserService;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = remoteUserService.info(username);
        return new SecurityUser(user.getUsername(), user.getPassword(), user.getId());
    }
}
