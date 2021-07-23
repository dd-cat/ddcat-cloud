package com.ddcat.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddcat.entity.SysDictItem;
import com.ddcat.entity.dict.DictItemDTO;
import com.ddcat.enums.ResultEnum;
import com.ddcat.exception.BusinessException;
import com.ddcat.mapper.SysDictItemMapper;
import com.ddcat.service.SysDictItemService;
import org.springframework.stereotype.Service;

/**
 * @author dd-cat
 */
@Service
public class SysDictItemServiceImpl extends ServiceImpl<SysDictItemMapper, SysDictItem> implements SysDictItemService {
    @Override
    public void saveOrUpdate(DictItemDTO dto) {
        LambdaQueryWrapper<SysDictItem> queryWrapper = Wrappers.<SysDictItem>lambdaQuery()
                .eq(SysDictItem::getType, dto.getType())
                .and(i ->
                        i.eq(SysDictItem::getName, dto.getName())
                                .or()
                                .eq(SysDictItem::getValue, dto.getValue()));
        if (dto.getId() != null) {
            queryWrapper.ne(SysDictItem::getId, dto.getId());
        }
        Integer count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new BusinessException(ResultEnum.B000008);
        }
        SysDictItem entity = new SysDictItem();
        BeanUtil.copyProperties(dto, entity);
        super.saveOrUpdate(entity);
    }
}
