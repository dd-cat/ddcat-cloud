package com.ddcat.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddcat.api.entity.SysUser;
import com.ddcat.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author dd-cat
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserService sysUserService;


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * 分页查询
     */
    @GetMapping("/page")
    public IPage<SysUser> page(Page page, SysUser sysUser) {
        return sysUserService.page(page, Wrappers.lambdaQuery(sysUser));
    }

    /**
     * 通过id查询
     */
    @GetMapping("/{id}")
    public SysUser getById(@PathVariable("id") Long id) {
        return sysUserService.getById(id);
    }

    /**
     * 新增
     */
    @PostMapping
    public boolean save(@RequestBody @Validated SysUser sysUser) {
        return sysUserService.save(sysUser);
    }

    /**
     * 修改
     */
    @PutMapping
    public boolean updateById(@RequestBody @Validated SysUser sysUser) {
        return sysUserService.updateById(sysUser);
    }

    /**
     * 通过id删除
     */
    @DeleteMapping("/{id}")
    public boolean removeById(@PathVariable Long id) {
        return sysUserService.removeById(id);
    }

}
