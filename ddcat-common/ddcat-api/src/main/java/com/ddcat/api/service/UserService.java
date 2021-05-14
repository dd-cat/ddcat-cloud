package com.ddcat.api.service;

import com.ddcat.api.entity.UserInfo;

/**
 * @author dd-cat
 */
public interface UserService {

    /**
     * 根据用户名获取用户信息
     *
     * @param username /
     * @return /
     * @throws Exception /
     */
    UserInfo info(String username) throws Exception;
}
