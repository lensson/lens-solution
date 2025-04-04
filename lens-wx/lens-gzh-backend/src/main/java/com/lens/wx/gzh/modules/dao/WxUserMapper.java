package com.lens.wx.gzh.modules.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lens.wx.gzh.modules.entity.WxUser;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface WxUserMapper extends BaseMapper<WxUser> {

    void unsubscribe(String openid);
}
