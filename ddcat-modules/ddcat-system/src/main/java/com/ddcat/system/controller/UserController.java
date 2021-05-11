package com.ddcat.system.controller;

import com.ddcat.api.entity.SysUser;
import com.ddcat.api.service.UserService;
import com.ddcat.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dd-cat
 */
@RestController
public class UserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }


}
