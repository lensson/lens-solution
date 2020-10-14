package com.lens.wx.gzh.message.service.impl;

import com.lens.wx.gzh.message.entity.Msg;
import com.lens.wx.gzh.message.mapper.MsgMapper;
import com.lens.wx.gzh.message.service.IMsgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信消息 服务实现类
 * </p>
 *
 * @author Lens Chen
 * @since 2020-10-14
 */
@Service
public class MsgServiceImpl extends ServiceImpl<MsgMapper, Msg> implements IMsgService {

}
