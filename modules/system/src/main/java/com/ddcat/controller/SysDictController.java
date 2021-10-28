package com.ddcat.controller;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddcat.entity.SysDict;
import com.ddcat.entity.dict.DictDTO;
import com.ddcat.entity.dict.DictPageDTO;
import com.ddcat.service.SysDictService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 字典
 *
 * @author dd-cat
 */
@RequestMapping("dict")
@RestController
@RequiredArgsConstructor
public class SysDictController {

    private final SysDictService service;

    /**
     * 根据ID查询单个
     *
     * @param id -
     */
    @GetMapping("{id}")
    public SysDict getById(@PathVariable long id) {
        return service.getById(id);
    }

    /**
     * 分页查询
     *
     * @param dto -
     * @return -
     */
    @PostMapping("page")
    public IPage<SysDict> page(@Valid @RequestBody DictPageDTO dto) {
        return service.page(new Page<>(dto.getCurrent(), dto.getSize()), Wrappers.<SysDict>lambdaQuery()
                .like(CharSequenceUtil.isNotBlank(dto.getName()), SysDict::getName, dto.getName()));
    }

    /**
     * 字典保存or修改
     *
     * @param dto -
     */
    @PostMapping
    public void saveOrUpdate(@Valid @RequestBody DictDTO dto) {
        service.saveOrUpdate(dto);
    }

    /**
     * 字典删除
     *
     * @param id -
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        service.removeById(id);
    }
}
