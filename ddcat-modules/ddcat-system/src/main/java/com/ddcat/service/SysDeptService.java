package com.ddcat.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ddcat.entity.SysDept;
import com.ddcat.entity.dept.DeptDTO;
import com.ddcat.entity.dept.DeptPageDTO;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author dd-cat
 */
public interface SysDeptService extends IService<SysDept> {
    /**
     * 获取树形数据
     *
     * @param all -
     * @return -
     */
    List<Tree<Long>> tree(Set<SysDept> all);


    /**
     * 分页查询
     *
     * @param dto -
     * @return -
     */
    IPage<SysDept> page(DeptPageDTO dto);

    /**
     * 保存or修改
     *
     * @param dto -
     * @throws IOException -
     */
    void saveOrUpdate(DeptDTO dto) throws IOException;

    /**
     * 删除
     *
     * @param id -
     */
    void removeById(long id);

}
