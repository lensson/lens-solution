package com.lens.wx.gzh.builder;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-13 1:55 PM
 */
@Slf4j
public abstract class AbstractBuilder {

    public abstract WxMpXmlOutMessage build(String content, WxMpXmlMessage wxMessage, WxMpService service);

}
