package com.ddcat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddcat.entity.SysDict;
import com.ddcat.entity.dict.DictDTO;

/**
 * @author dd-cat
 */
public interface SysDictService extends IService<SysDict> {

    /**
     * 字典保存or修改
     *
     * @param dto -
     */
    void saveOrUpdate(DictDTO dto);

    /**
     * 删除字典and字典项
     *
     * @param id -
     */
    void removeById(long id);

}
