package com.ddcat.system.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddcat.api.entity.SysUser;
import com.ddcat.system.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author dd-cat
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class SysUserController {

    private final SysUserService userService;

    @GetMapping("page")
    public IPage<SysUser> page(Page<SysUser> page, SysUser user) {
        return userService.page(page, Wrappers.query(user));
    }

    @GetMapping("list")
    public List<SysUser> list(SysUser user) {
        return userService.list(Wrappers.query(user));
    }

    /**
     * 通过ID查询
     *
     * @param id ID
     */
    @GetMapping("/{id}")
    public SysUser getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    /**
     * 添加
     *
     * @param sysUser 实体
     */
    @PostMapping
    public boolean save(@Valid @RequestBody SysUser sysUser) {
        sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
        return userService.save(sysUser);
    }

    /**
     * 删除
     *
     * @param ids ids
     */
    @DeleteMapping("/{ids}")
    public boolean removeByIds(@PathVariable List<Long> ids) {
        return userService.removeByIds(ids);
    }

    /**
     * 编辑
     *
     * @param sysUser 实体
     */
    @PutMapping
    public boolean update(@RequestBody SysUser sysUser) {
        if (StrUtil.isNotBlank(sysUser.getPassword())) {
            sysUser.setPassword(new BCryptPasswordEncoder().encode(sysUser.getPassword()));
        }
        return userService.updateById(sysUser);
    }

}
