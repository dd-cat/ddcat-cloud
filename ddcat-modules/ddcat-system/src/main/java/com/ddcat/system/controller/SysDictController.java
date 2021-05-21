package com.ddcat.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddcat.api.entity.SysDict;
import com.ddcat.api.entity.SysDictItem;
import com.ddcat.core.constant.CacheConstants;
import com.ddcat.system.service.SysDictItemService;
import com.ddcat.system.service.SysDictService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * @author dd-cat
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/dict")
public class SysDictController {
    private final SysDictItemService sysDictItemService;

    private final SysDictService sysDictService;

    /**
     * 通过ID查询字典信息
     *
     * @param id ID
     * @return 字典信息
     */
    @GetMapping("/{id}")
    public SysDict getById(@PathVariable Integer id) {
        return sysDictService.getById(id);
    }

    /**
     * 分页查询字典信息
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public IPage<SysDict> getDictPage(Page<SysDict> page, SysDict sysDict) {
        return sysDictService.page(page, Wrappers.query(sysDict));
    }

    /**
     * 通过字典类型查找字典
     *
     * @param type 类型
     * @return 同类型字典
     */
    @GetMapping("/type/{type}")
    @Cacheable(value = CacheConstants.DICT_DETAILS, key = "#type")
    public List<SysDictItem> getDictByType(@PathVariable String type) {
        return sysDictItemService.list(Wrappers.<SysDictItem>query().lambda().eq(SysDictItem::getType, type));
    }

    /**
     * 添加字典
     *
     * @param sysDict 字典信息
     * @return success、false
     */
    @PostMapping
    public Boolean save(@Valid @RequestBody SysDict sysDict) {
        return sysDictService.save(sysDict);
    }

    /**
     * 删除字典，并且清除字典缓存
     *
     * @param id 字典ID
     * @return /
     */
    @DeleteMapping("/{id}")
    public Integer removeById(@PathVariable Integer id) {
        return sysDictService.removeDict(id);
    }

    /**
     * 修改字典
     *
     * @param sysDict 字典信息
     * @return success/false
     */
    @PutMapping
    public Boolean updateById(@Valid @RequestBody SysDict sysDict) {
        return sysDictService.updateById(sysDict);
    }

    /**
     * 分页查询
     *
     * @param page        分页对象
     * @param sysDictItem 字典详情
     * @return /
     */
    @GetMapping("/item/page")
    public IPage<SysDictItem> getSysDictItemPage(Page<SysDictItem> page, SysDictItem sysDictItem) {
        return sysDictItemService.page(page, Wrappers.query(sysDictItem));
    }

    /**
     * 通过id查询字典详情
     *
     * @param id 字典详情ID
     * @return /
     */
    @GetMapping("/item/{id}")
    public SysDictItem getDictItemById(@PathVariable("id") Integer id) {
        return sysDictItemService.getById(id);
    }

    /**
     * 新增字典详情
     *
     * @param sysDictItem 字典详情
     * @return /
     */
    @PostMapping("/item")
    @CacheEvict(value = CacheConstants.DICT_DETAILS, allEntries = true)
    public Boolean save(@RequestBody SysDictItem sysDictItem) {
        return sysDictItemService.save(sysDictItem);
    }

    /**
     * 修改字典详情
     *
     * @param sysDictItem 字典详情
     * @return /
     */
    @PutMapping("/item")
    @CacheEvict(value = CacheConstants.DICT_DETAILS, allEntries = true)
    public Boolean updateById(@RequestBody SysDictItem sysDictItem) {
        return sysDictItemService.updateById(sysDictItem);
    }

    /**
     * 通过id删除字典详情
     *
     * @param id 字典详情ID
     * @return /
     */
    @DeleteMapping("/item/{id}")
    @CacheEvict(value = CacheConstants.DICT_DETAILS, allEntries = true)
    public Boolean removeDictItemById(@PathVariable Integer id) {
        return sysDictItemService.removeById(id);
    }


}
