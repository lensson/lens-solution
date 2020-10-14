package com.lens.wx.gzh.handler;

import com.lens.wx.gzh.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-13 2:51 PM
 */
@Slf4j
@Component
public class LogHandler extends AbstractHandler{
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
        this.log.info("\n接收到请求消息，内容：{}", JsonUtils.toJson(wxMessage));
        return null;
    }
}
