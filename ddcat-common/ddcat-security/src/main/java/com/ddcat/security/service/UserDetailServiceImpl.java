package com.ddcat.security.service;

import com.ddcat.api.entity.UserInfo;
import com.ddcat.api.service.UserService;
import com.ddcat.security.entity.UserBean;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dd-cat
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @DubboReference
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(123456778);
        UserInfo userInfo = userService.info(username);
        System.out.println("result:" + userInfo);
        return getUserDetails(userInfo);
    }

    /**
     * 构建 UserDetails
     */
    private UserDetails getUserDetails(UserInfo userInfo) {

        List<GrantedAuthority> authorities = userInfo.getPermissions().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        // 构造security用户
        return new UserBean(userInfo.getUser(), userInfo.getRoles(), authorities);
    }
}
