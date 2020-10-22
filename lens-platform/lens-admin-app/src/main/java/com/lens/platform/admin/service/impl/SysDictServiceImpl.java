package com.lens.platform.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lens.platform.admin.entity.SysDict;
import com.lens.platform.admin.mapper.SysDictMapper;
import com.lens.platform.admin.service.ISysDictService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements ISysDictService {

    @Override
    public IPage<SysDict> list(Page<SysDict> page, SysDict dict) {
        List<SysDict> list = this.baseMapper.list(page,dict);
        page.setRecords(list);
        return page;
    }
}
