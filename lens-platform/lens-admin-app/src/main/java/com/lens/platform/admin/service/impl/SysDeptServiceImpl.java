package com.lens.platform.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lens.platform.admin.common.AdminConstant;
import com.lens.platform.admin.entity.SysDept;
import com.lens.platform.admin.mapper.SysDeptMapper;
import com.lens.platform.admin.service.ISysDeptService;
import com.lens.platform.admin.vo.DeptVO;
import com.lens.platform.admin.vo.TreeSelectVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

    @Override
    public List<DeptVO> listForTableData(LambdaQueryWrapper<SysDept> baseQuery) {
        List<SysDept> deptList = this.baseMapper.selectList(baseQuery);
        List<DeptVO> list = recursionForTableData(AdminConstant.ROOT_DEPT_ID, deptList);
        return list;
    }

    @Override
    public List<TreeSelectVO> listForTreeSelect(LambdaQueryWrapper<SysDept> baseQuery) {
        List<SysDept> deptList = this.baseMapper.selectList(baseQuery);
        List<TreeSelectVO> list = recursionForTreeSelect(AdminConstant.ROOT_DEPT_ID, deptList);
        return list;
    }

    /**
     * 递归生成部门表格数据
     * @param parentId
     * @param deptList
     * @return
     */
    public static List<DeptVO> recursionForTableData(int parentId, List<SysDept> deptList) {
        List<DeptVO> list = new ArrayList<>();
        Optional.ofNullable(deptList).orElse(new ArrayList<>())
                .stream()
                .filter(dept -> dept.getParentId().equals(parentId))
                .forEach(dept -> {
                    DeptVO deptVO = new DeptVO();
                    BeanUtil.copyProperties(dept, deptVO);
                    List<DeptVO> children = recursionForTableData(dept.getId(), deptList);
                    deptVO.setChildren(children);
                    list.add(deptVO);
                });
        return list;
    }


    /**
     * 递归生成部门树形下拉数据
     * @param parentId
     * @param deptList
     * @return
     */
    public static List<TreeSelectVO> recursionForTreeSelect(int parentId, List<SysDept> deptList) {
        List<TreeSelectVO> list = new ArrayList<>();
        Optional.ofNullable(deptList).orElse(new ArrayList<>())
                .stream()
                .filter(dept -> dept.getParentId().equals(parentId))
                .forEach(dept -> {
                    TreeSelectVO treeSelectVO = new TreeSelectVO();
                    treeSelectVO.setId(dept.getId());
                    treeSelectVO.setLabel(dept.getName());
                    List<TreeSelectVO> children = recursionForTreeSelect(dept.getId(), deptList);
                    treeSelectVO.setChildren(children);
                    list.add(treeSelectVO);
                });
        return list;
    }

}
