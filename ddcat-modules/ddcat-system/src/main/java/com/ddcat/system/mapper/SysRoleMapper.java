package com.ddcat.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ddcat.api.entity.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author dd-cat
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 获取用户角色
     *
     * @param userId /
     * @return /
     */
    @Select("select role_id from sys_user_role where user_id=#{userId}")
    List<Long> getRoleIdByUserId(Long userId);
}
