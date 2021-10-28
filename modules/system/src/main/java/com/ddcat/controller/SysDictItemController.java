package com.ddcat.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ddcat.constant.CacheConstants;
import com.ddcat.entity.SysDictItem;
import com.ddcat.entity.dict.DictItemDTO;
import com.ddcat.entity.dict.DictItemUpdateDTO;
import com.ddcat.service.SysDictItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 字典
 *
 * @author dd-cat
 */
@RequestMapping("dict/item")
@RestController
@RequiredArgsConstructor
public class SysDictItemController {

    private final SysDictItemService service;

    /**
     * 查询单个
     *
     * @param id -
     */
    @GetMapping("{id}")
    public SysDictItem getById(@PathVariable long id) {
        return service.getById(id);
    }

    /**
     * 根据type获取字典项
     *
     * @param type -
     * @return -
     */
    @GetMapping("type/{type}")
    @Cacheable(value = CacheConstants.DICT, key = "#type")
    public List<SysDictItem> select(@PathVariable String type) {
        return service.list(Wrappers.<SysDictItem>lambdaQuery().eq(SysDictItem::getType, type).orderByAsc(SysDictItem::getSort));
    }

    /**
     * 字典项保存or修改
     *
     * @param dto -
     */
    @PostMapping
    @CacheEvict(value = CacheConstants.DICT, allEntries = true)
    public void saveOrUpdate(@Valid @RequestBody DictItemDTO dto) {
        service.saveOrUpdate(dto);
    }

    /**
     * 批量更新字典项
     *
     * @param dto -
     */
    @PostMapping("updateItems")
    @CacheEvict(value = CacheConstants.DICT, allEntries = true)
    public void updateItems(@Valid @RequestBody DictItemUpdateDTO dto) {
        service.updateBatchById(dto.getDictItemList());
    }

    /**
     * 字典项删除
     *
     * @param id -
     */
    @DeleteMapping("/{id}")
    @CacheEvict(value = CacheConstants.DICT, allEntries = true)
    public void deleteItem(@PathVariable long id) {
        service.removeById(id);
    }
}
