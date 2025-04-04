package com.lens.wx.gzh.modules.wx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lens.wx.gzh.common.utils.PageUtils;
import com.lens.wx.gzh.modules.entity.WxQrCode;
import com.lens.wx.gzh.modules.wx.form.WxQrCodeForm;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;

import java.util.Map;

/**
 * 公众号带参二维码
 *
 * @author niefy
 * @email niefy@qq.com
 * @date 2020-01-02 11:11:55
 */
public interface WxQrCodeService extends IService<WxQrCode> {

    /**
     * 分页查询用户数据
     * @param params 查询参数
     * @return PageUtils 分页结果
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 创建公众号带参二维码
     *
     *
     * @param appid
     * @param form
     * @return
     */
    WxMpQrCodeTicket createQrCode(String appid, WxQrCodeForm form) throws WxErrorException;
}

