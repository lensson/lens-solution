package com.lens.wx.gzh.modules.oss.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lens.wx.gzh.modules.oss.dao.SysOssDao;
import com.lens.wx.gzh.modules.oss.entity.SysOssEntity;
import com.lens.wx.gzh.modules.oss.service.SysOssService;
import com.lens.wx.gzh.common.utils.PageUtils;
import com.lens.wx.gzh.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysOssEntity> page = this.page(
            new Query<SysOssEntity>().getPage(params)
        );

        return new PageUtils(page);
    }

}
