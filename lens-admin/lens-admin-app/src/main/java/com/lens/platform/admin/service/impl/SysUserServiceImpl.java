package com.lens.platform.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lens.platform.admin.entity.SysUser;
import com.lens.platform.admin.mapper.SysUserMapper;
import com.lens.platform.admin.service.ISysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public IPage<SysUser> list(Page<SysUser> page,SysUser sysUser ) {
        List<SysUser> list = this.baseMapper.list(page,sysUser);
        page.setRecords(list);
        return page;
    }


}
