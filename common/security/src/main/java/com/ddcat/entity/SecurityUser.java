package com.ddcat.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author dd-cat
 */
public class SecurityUser extends User {
    /**
     * 存储用户的id 为了方便查询用户详细信息
     */
    @Getter
    @Setter
    private Long userId;

    public SecurityUser(String username, String password, Long userId) {
        super(username, password, AuthorityUtils.NO_AUTHORITIES);
        this.userId = userId;
    }

    public SecurityUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
}
