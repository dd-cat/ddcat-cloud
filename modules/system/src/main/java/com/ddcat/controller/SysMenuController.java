package com.ddcat.controller;

import cn.hutool.core.lang.tree.Tree;
import com.ddcat.entity.SysMenu;
import com.ddcat.entity.menu.MenuDTO;
import com.ddcat.service.SysMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 菜单
 *
 * @author dd-cat
 */
@RequestMapping("menu")
@RestController
@RequiredArgsConstructor
public class SysMenuController {

    private final SysMenuService service;

    /**
     * 根据ID查询单个
     *
     * @param id -
     */
    @GetMapping("{id}")
    public SysMenu getById(@PathVariable long id) {
        return service.getById(id);
    }

    /**
     * 获取树形数据
     *
     * @return -
     */
    @GetMapping("tree")
    public List<Tree<Long>> tree() {
        Set<SysMenu> all = new HashSet<>(service.list());
        return service.tree(all);
    }

    /**
     * 保存or修改
     *
     * @return -
     */
    @PostMapping
    public void saveOrUpdate(@Valid @RequestBody MenuDTO dto) {
        SysMenu entity = new SysMenu();
        BeanUtils.copyProperties(dto, entity);
        service.saveOrUpdate(entity);
    }

    /**
     * 删除
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        service.removeById(id);
    }

    /**
     * 通过角色ID获取菜单ID
     *
     * @param id -
     * @return -
     */
    @GetMapping("getByRoleId/{id}")
    public List<Long> getByRoleId(@PathVariable long id) {
        return service.getByRoleId(id);
    }

    /**
     * 当前登录人菜单信息
     *
     * @return -
     */
    @GetMapping
    public List<Tree<Long>> getUserMenus() {
        return service.getUserMenus();
    }
}
