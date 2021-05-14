package com.ddcat.api.service;

import com.ddcat.api.entity.UserInfo;

/**
 * @author dd-cat
 */
public interface UserService {

    UserInfo info(String username) throws Exception;
}
