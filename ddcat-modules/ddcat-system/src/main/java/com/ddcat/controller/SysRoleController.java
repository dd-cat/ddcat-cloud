package com.ddcat.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ddcat.entity.SysRole;
import com.ddcat.entity.role.RoleDTO;
import com.ddcat.entity.role.RolePageDTO;
import com.ddcat.service.SysRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 角色
 *
 * @author dd-cat
 */
@RequestMapping("role")
@RestController
@RequiredArgsConstructor
public class SysRoleController {

    private final SysRoleService service;

    /**
     * 根据ID查询单个
     *
     * @param id -
     */
    @GetMapping("{id}")
    public SysRole getById(@PathVariable long id) {
        return service.getById(id);
    }

    /**
     * 保存or修改
     *
     * @param dto -
     */
    @PostMapping
    public void saveOrUpdate(@Valid @RequestBody RoleDTO dto) {
        service.saveOrUpdate(dto);
    }

    /**
     * 分页查询
     *
     * @param dto -
     */
    @PostMapping("page")
    public IPage<SysRole> page(@Valid @RequestBody RolePageDTO dto) {
        return service.page(dto);
    }

    /**
     * 删除
     *
     * @param id -
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        service.removeById(id);
    }
}
