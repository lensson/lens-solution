package com.lens.platform.admin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lens.platform.admin.entity.SysRole;

import java.util.List;

public interface ISysRoleService extends IService<SysRole> {

    boolean update(SysRole role);

    boolean delete(List<Integer> ids);

    boolean add(SysRole role);

    boolean update(Integer id, List<Integer> resourceIds);
}
