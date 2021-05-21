package com.ddcat.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddcat.api.entity.SysDict;
import com.ddcat.api.entity.SysDictItem;
import com.ddcat.core.constant.CacheConstants;
import com.ddcat.system.mapper.SysDictItemMapper;
import com.ddcat.system.mapper.SysDictMapper;
import com.ddcat.system.service.SysDictService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dd-cat
 */
@Service
@RequiredArgsConstructor
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {
    private final SysDictItemMapper dictItemMapper;

    /**
     * 根据ID 删除字典
     *
     * @param id 字典ID
     * @return /
     */
    @Override
    @CacheEvict(value = CacheConstants.DICT_DETAILS, allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public int removeDict(Integer id) {
        baseMapper.deleteById(id);
        return dictItemMapper.delete(Wrappers.<SysDictItem>lambdaQuery().eq(SysDictItem::getDictId, id));
    }

}
