package com.ddcat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ddcat.entity.SysUser;
import com.ddcat.entity.user.*;

/**
 * @author dd-cat
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 保存or修改
     *
     * @param dto -
     */
    void saveOrUpdate(UserDTO dto);

    /**
     * 分页查询
     *
     * @param dto -
     * @return -
     */
    IPage<UserPageVO> page(UserPageDTO dto);

    /**
     * 当前登录用户信息
     *
     * @return -
     */
    UserLoginVO info();

    /**
     * 修改当前登陆人密码
     *
     * @param dto -
     */
    void updatePassword(UserPasswordDTO dto);

    /**
     * 删除
     *
     * @param id -
     */
    void removeById(long id);
}
