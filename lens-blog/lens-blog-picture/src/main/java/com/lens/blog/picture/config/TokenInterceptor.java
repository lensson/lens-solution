package com.lens.blog.picture.config;

import com.lens.blog.common.entity.OnlineAdmin;
import com.lens.blog.picture.global.RedisConf;
import com.lens.blog.picture.global.SysConf;
import com.lens.blog.utils.JsonUtils;
import com.lens.blog.utils.RedisUtil;
import com.lens.blog.utils.SpringUtils;
import com.lens.blog.utils.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * token拦截器
 *
 * @author: Lens
 * @create: 2020-06-14-21:55
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        StringBuffer requestURL = request.getRequestURL();
        //得到请求头信息authorization信息
        String authHeader = "";

        if (request.getHeader("Authorization") != null) {
            authHeader = request.getHeader("Authorization");
        } else if (request.getParameter(SysConf.TOKEN) != null) {
            authHeader = request.getParameter(SysConf.TOKEN);
        }

        if (StringUtils.isNotEmpty(authHeader) && authHeader.startsWith("bearer_")) {
            // 获取在线的管理员信息
            RedisUtil redisUtil = SpringUtils.getBean(RedisUtil.class);
            String onlineAdmin = redisUtil.get(RedisConf.LOGIN_TOKEN_KEY + RedisConf.SEGMENTATION + authHeader);
            if (StringUtils.isNotEmpty(onlineAdmin)) {
                // 得到管理员UID和 Name
                OnlineAdmin admin = JsonUtils.jsonToPojo(onlineAdmin, OnlineAdmin.class);
                request.setAttribute(SysConf.ADMIN_UID, admin.getAdminUid());
                request.setAttribute(SysConf.NAME, admin.getUserName());
                request.setAttribute(SysConf.TOKEN, authHeader);
            }
        }
        return true;
    }

}

