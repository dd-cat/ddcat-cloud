package com.ddcat.job.controller;

import com.ddcat.api.entity.SysUser;
import com.ddcat.api.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dd-cat
 */
@RestController
public class UserController {

    @DubboReference
    private UserService userService;

    @GetMapping("add")
    public SysUser add(SysUser user) {
        return userService.save(user);
    }


    @GetMapping("list")
    public List<SysUser> list() {
        return userService.list();
    }

}
