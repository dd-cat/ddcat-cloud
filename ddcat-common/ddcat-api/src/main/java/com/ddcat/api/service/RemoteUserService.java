package com.ddcat.api.service;

import com.ddcat.api.entity.UserInfo;

/**
 * 用户Dubbo接口
 *
 * @author dd-cat
 */
public interface RemoteUserService {

    /**
     * 根据用户名获取用户信息
     *
     * @param username /
     * @return /
     * @throws Exception /
     */
    UserInfo info(String username) throws Exception;
}
