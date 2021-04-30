package com.ddcat.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.ddcat.system.entity.User;
import com.ddcat.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description:
 * @author: dd-cat
 * @date:2021/4/28 16:56
 * @version:1.0
 */
@RestController
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("hello")
    public String hello() {
        StpUtil.checkPermission("redis-console");    // 鉴权
        return "hello";
    }


    @GetMapping("login")
    public Map<String, String> login() {
        StpUtil.setLoginId(1);            // 写入session
        return StpUtil.getTokenInfo();
    }

    @GetMapping("add")
    public String add() {
        User user = new User();
        user.setId(1);
        user.setName("张三");
        userRepository.save(user);
        return "success";
    }
}
