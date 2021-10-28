package com.ddcat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddcat.entity.SysDictItem;
import com.ddcat.entity.dict.DictItemDTO;

/**
 * @author dd-cat
 */
public interface SysDictItemService extends IService<SysDictItem> {

    /**
     * 字典项保存or修改
     *
     * @param dto -
     */
    void saveOrUpdate(DictItemDTO dto);
}
