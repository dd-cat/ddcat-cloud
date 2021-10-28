package com.ddcat.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ddcat.entity.SysUser;
import com.ddcat.entity.user.*;
import com.ddcat.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 用户
 *
 * @author dd-cat
 */
@RequestMapping("user")
@RestController
@RequiredArgsConstructor
public class SysUserController {

    private final SysUserService service;

    /**
     * 当前登录用户信息
     */
    @GetMapping("info")
    public UserLoginVO info() {
        return service.info();
    }

    /**
     * 分页查询
     *
     * @param dto -
     */
    @PostMapping("page")
    public IPage<UserPageVO> page(@RequestBody UserPageDTO dto) {
        return service.page(dto);
    }

    /**
     * 根据ID查询单个
     *
     * @param id -
     */
    @GetMapping("{id}")
    public SysUser getById(@PathVariable long id) {
        return service.getById(id);
    }

    /**
     * 保存or修改
     *
     * @param dto -
     */
    @PostMapping
    public void saveOrUpdate(@Valid @RequestBody UserDTO dto) {
        service.saveOrUpdate(dto);
    }

    /**
     * 用户删除
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        service.removeById(id);
    }

    /**
     * 修改当前登陆人密码
     *
     * @param dto -
     */
    @PutMapping("/updatePassword")
    public void updatePassword(@RequestBody UserPasswordDTO dto) {
        service.updatePassword(dto);
    }

}
