package com.ddcat.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddcat.api.entity.SysMenu;
import com.ddcat.system.mapper.SysMenuMapper;
import com.ddcat.system.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dd-cat
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public List<SysMenu> findMenuByRoleId(Long roleId) {
        return baseMapper.listMenusByRoleId(roleId);
    }

    @Override
    public List<Tree<Long>> treeMenu(Set<SysMenu> all) {
        List<TreeNode<Long>> nodeList = CollUtil.newArrayList();
        for (SysMenu menu : all) {
            TreeNode<Long> treeNode = new TreeNode<>(menu.getId(), menu.getParentId(), menu.getName(), menu.getSort());
            Map<String, Object> extra = new HashMap<>();
            extra.put("path", menu.getPath());
            extra.put("icon", menu.getIcon());
            extra.put("permission", menu.getPermission());
            extra.put("component", menu.getComponent());
            if ("0".equals(menu.getType())) {
                extra.put("component", "Layout");
                extra.put("path", "/" + menu.getPath());
            }
            if (!"2".equals(menu.getType())) {
                extra.put("visible", menu.getVisible());
                extra.put("flag", menu.getFlag());
                extra.put("isCache", menu.getIsCache());
                extra.put("isFrame", menu.getIsFrame());
            }
            extra.put("sort", menu.getSort());
            extra.put("type", menu.getType());
            extra.put("createTime", menu.getCreateTime());
            treeNode.setExtra(extra);
            nodeList.add(treeNode);
        }
        return TreeUtil.build(nodeList, -1L);
    }

}
