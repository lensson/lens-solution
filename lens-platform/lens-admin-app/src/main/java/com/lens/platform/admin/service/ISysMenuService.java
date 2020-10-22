package com.lens.platform.admin.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lens.platform.admin.entity.SysMenu;
import com.lens.platform.admin.vo.MenuVO;
import com.lens.platform.admin.vo.TreeSelectVO;

import java.util.List;

public interface ISysMenuService extends IService<SysMenu> {

    List<MenuVO> listForTableData(LambdaQueryWrapper<SysMenu> baseQuery);

    List<TreeSelectVO> listForTreeSelect(LambdaQueryWrapper<SysMenu> baseQuery);

    List listForRouter();
}
