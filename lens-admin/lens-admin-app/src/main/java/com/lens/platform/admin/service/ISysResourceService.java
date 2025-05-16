package com.lens.platform.admin.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lens.platform.admin.entity.SysResource;
import com.lens.platform.admin.vo.TreeSelectVO;

import java.util.List;

public interface ISysResourceService extends IService<SysResource> {

    List<SysResource> listForResourceRoles();

    List<TreeSelectVO> listForTreeSelect(LambdaQueryWrapper<SysResource> baseQuery);
}
