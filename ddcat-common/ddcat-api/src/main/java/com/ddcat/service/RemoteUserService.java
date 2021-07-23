package com.ddcat.service;

import com.ddcat.entity.SysUser;

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
    SysUser info(String username) throws Exception;
}
