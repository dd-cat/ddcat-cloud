package com.ddcat.entity.user;

import com.ddcat.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author dd-cat
 */
@Data
@AllArgsConstructor
public class UserLoginVO {
    /**
     * 用户信息
     */
    private SysUser user;
    /**
     * 权限集合
     */
    private List<String> permissions;
    /**
     * 角色集合
     */
    private List<String> roles;
}
