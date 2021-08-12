package com.ddcat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ddcat.entity.SysUser;
import com.ddcat.entity.SysUserRole;
import com.ddcat.entity.user.UserPageDTO;
import com.ddcat.entity.user.UserPageVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author dd-cat
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
}
