package com.ddcat.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddcat.entity.SysMenu;
import com.ddcat.entity.SysRole;
import com.ddcat.entity.SysUser;
import com.ddcat.entity.SysUserRole;
import com.ddcat.entity.user.*;
import com.ddcat.enums.ResultEnum;
import com.ddcat.exception.BusinessException;
import com.ddcat.mapper.SysDeptMapper;
import com.ddcat.mapper.SysUserMapper;
import com.ddcat.service.SysMenuService;
import com.ddcat.service.SysRoleService;
import com.ddcat.service.SysUserRoleService;
import com.ddcat.service.SysUserService;
import com.ddcat.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author dd-cat
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Value("${password:e10adc3949ba59abbe56e057f20f883e}")
    private String password;

    private final SysDeptMapper deptMapper;
    private final SysRoleService roleService;
    private final SysMenuService menuService;
    private final SysUserRoleService sysUserRoleService;

    @Override
    public void saveOrUpdate(UserDTO dto) {
        // 验证账号是否已经存在
        LambdaQueryWrapper<SysUser> queryWrapper = Wrappers.<SysUser>lambdaQuery()
                .eq(SysUser::getAccount, dto.getAccount());
        if (dto.getId() != null) {
            queryWrapper.ne(SysUser::getId, dto.getId());
        }
        Integer count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new BusinessException(ResultEnum.B000003);
        }
        // 验证身份证信息
        if (CharSequenceUtil.isNotBlank(dto.getIdCard())) {
            boolean validCard = IdcardUtil.isValidCard(dto.getIdCard());
            if (!validCard) {
                throw new BusinessException(ResultEnum.B000004);
            }
        }
        SysUser entity = new SysUser();
        BeanUtil.copyProperties(dto, entity);
        if (entity.getId() == null) {
            // 初始化密码
            entity.setPassword(password);
        }
        super.saveOrUpdate(entity);
        // 添加用户角色关联信息
        if (ArrayUtil.isNotEmpty(dto.getRoleIds())) {
            sysUserRoleService.remove(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, entity.getId()));
            List<SysUserRole> list = new ArrayList<>();
            for (long roleId : dto.getRoleIds()) {
                SysUserRole userRole = new SysUserRole();
                userRole.setUserId(entity.getId());
                userRole.setRoleId(roleId);
                list.add(userRole);
            }
            sysUserRoleService.saveBatch(list);
        }
    }

    @Override
    public IPage<UserPageVO> page(UserPageDTO dto) {
        List<Long> ids = new ArrayList<>();
        Long deptId = dto.getDeptId();
        if (deptId != null) {
            ids = deptMapper.selectTreeId(deptId);
            ids.add(dto.getDeptId());
        }
        return baseMapper.page(new Page<>(dto.getCurrent(), dto.getSize()), dto, ids);
    }

    @Override
    public UserLoginVO info() {
        SysUser entity = this.getById(SecurityUtil.getUserId());
        Set<String> permissions = new HashSet<>();
        //通过用户角色ID 获取用户权限列表
        List<SysRole> roles = roleService.findRolesByUserId(entity.getId());

        List<String> roleCodes = roles.stream().map(SysRole::getCode).collect(Collectors.toList());

        List<Long> roleIds = roles.stream().map(SysRole::getId).collect(Collectors.toList());
        roleIds.forEach(roleId -> {
            List<String> permissionList = menuService.findMenuByRoleId(roleId).stream()
                    .map(SysMenu::getPermission).filter(StrUtil::isNotEmpty)
                    .collect(Collectors.toList());
            permissions.addAll(permissionList);
        });
        return new UserLoginVO(entity, new ArrayList<>(permissions), roleCodes);
    }

    @Override
    public void updatePassword(UserPasswordDTO dto) {
        SysUser user = baseMapper.selectById(SecurityUtil.getUserId());
        // 判断旧密码 和 原密码是否一致
        if (!user.getPassword().equals(SecureUtil.md5(dto.getOldPassword()))) {
            throw new BusinessException(ResultEnum.B000005);
        }
        user.setPassword(SecureUtil.md5(dto.getNewPassword()));
        baseMapper.updateById(user);
    }

    @Override
    public void removeById(long id) {
        Long userId = SecurityUtil.getUserId();
        if (id == userId) {
            throw new BusinessException(ResultEnum.B000002);
        }
        int i = baseMapper.deleteById(id);
        // 删除用户角色关联
        if (i > 0) {
            sysUserRoleService.remove(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, id));
        }
    }
}
