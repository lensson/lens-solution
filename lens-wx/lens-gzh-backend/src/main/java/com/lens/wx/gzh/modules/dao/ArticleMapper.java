package com.lens.wx.gzh.modules.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lens.wx.gzh.modules.entity.Article;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.scheduling.annotation.Async;

@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface ArticleMapper extends BaseMapper<Article> {
    @Async
    void addOpenCount(int id);
}
