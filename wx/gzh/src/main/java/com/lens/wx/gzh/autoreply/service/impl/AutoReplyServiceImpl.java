package com.lens.wx.gzh.autoreply.service.impl;

import com.lens.wx.gzh.autoreply.entity.AutoReply;
import com.lens.wx.gzh.autoreply.mapper.AutoReplyMapper;
import com.lens.wx.gzh.autoreply.service.IAutoReplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信自动回复 服务实现类
 * </p>
 *
 * @author Lens Chen
 * @since 2020-10-14
 */
@Service
public class AutoReplyServiceImpl extends ServiceImpl<AutoReplyMapper, AutoReply> implements IAutoReplyService {

    @Autowired
    AutoReplyMapper autoReplyMapper;
}
