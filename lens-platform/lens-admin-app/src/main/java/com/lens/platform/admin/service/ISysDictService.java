package com.lens.platform.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lens.platform.admin.entity.SysDict;

public interface ISysDictService extends IService<SysDict> {

    IPage<SysDict> list(Page<SysDict> page, SysDict dict);
}
