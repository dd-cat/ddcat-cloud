package com.ddcat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ddcat.entity.SysRole;
import com.ddcat.entity.role.RoleDTO;
import com.ddcat.entity.role.RolePageDTO;

import java.util.List;


/**
 * @author dd-cat
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 分页查询
     *
     * @param dto -
     * @return -
     */
    IPage<SysRole> page(RolePageDTO dto);

    /**
     * 保存or修改
     *
     * @param dto -
     */
    void saveOrUpdate(RoleDTO dto);

    /**
     * 删除
     *
     * @param id -
     * @return -
     */
    void removeById(long id);

    /**
     * 通过用户ID，查询角色信息
     *
     * @param userId 用户id
     * @return -
     */
    List<SysRole> findRolesByUserId(Long userId);
}
