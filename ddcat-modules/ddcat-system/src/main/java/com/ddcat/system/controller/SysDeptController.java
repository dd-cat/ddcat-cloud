package com.ddcat.system.controller;

import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.hutool.core.lang.tree.Tree;
import com.ddcat.api.entity.SysDept;
import com.ddcat.core.annotation.SysLog;
import com.ddcat.core.util.ExcelUtils;
import com.ddcat.system.service.SysDeptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dd-cat
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/dept")
public class SysDeptController {
    private final SysDeptService deptService;

    /**
     * 部门树
     *
     * @return 部门信息
     */
    @GetMapping("tree")
    @SysLog("部门树")
    public List<Tree<Long>> tree() {
        Set<SysDept> all = new HashSet<>(deptService.list());
        return deptService.treeDept(all);
    }

    /**
     * 通过ID查询部门
     *
     * @param id ID
     */
    @GetMapping("/{id}")
    @SysLog("通过ID查询部门")
    public SysDept getById(@PathVariable Integer id) {
        return deptService.getById(id);
    }

    /**
     * 添加
     *
     * @param sysDept 实体
     */
    @PostMapping
    @SysLog("添加部门")
    public boolean save(@RequestBody SysDept sysDept) {
        return deptService.save(sysDept);
    }

    /**
     * 删除
     *
     * @param ids ids
     */
    @DeleteMapping("/{ids}")
    @SysLog("删除部门")
    public boolean removeByIds(@PathVariable List<Long> ids) {
        return deptService.removeByIds(ids);
    }

    /**
     * 编辑
     *
     * @param sysDept 实体
     */
    @PutMapping
    @SysLog("更新部门")
    public boolean update(@RequestBody SysDept sysDept) {
        return deptService.updateById(sysDept);
    }

    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {

        List<SysDept> list = deptService.list();
        List<ExcelExportEntity> colList = new ArrayList<ExcelExportEntity>();
        colList.add(new ExcelExportEntity("ID", "id"));
        colList.add(new ExcelExportEntity("部门名称", "name"));
        ExcelUtils.exportExcel(list, null, "1234", "express", response, colList);
    }
}
