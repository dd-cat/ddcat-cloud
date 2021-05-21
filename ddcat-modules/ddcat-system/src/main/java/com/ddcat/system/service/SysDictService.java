package com.ddcat.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddcat.api.entity.SysDict;

/**
 * @author dd-cat
 */
public interface SysDictService extends IService<SysDict> {
    /**
     * 根据ID 删除字典
     *
     * @param id /
     * @return /
     */
    int removeDict(Integer id);

}
