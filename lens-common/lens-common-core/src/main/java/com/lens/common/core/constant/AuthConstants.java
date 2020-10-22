package com.lens.common.core.constant;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-16 1:31 PM
 */
public interface AuthConstants {

    /**
     * JWT存储权限前缀
     */
    String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT存储权限属性
     */
    String AUTHORITY_CLAIM_NAME = "authorities";

    /**
     * 认证信息Http请求头
     */
    String JWT_TOKEN_HEADER = "Authorization";

    /**
     * JWT令牌前缀
     */
    String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * JWT载体key
     */
    String JWT_PAYLOAD_KEY = "payload";

    /**
     * Redis缓存权限规则key
     */
    String RESOURCE_ROLES_KEY = "auth:resourceRoles";

    /**
     * 黑名单token前缀
     */
    String TOKEN_BLACKLIST_PREFIX = "auth:token:blacklist:";

    /**
     * 密码加密方式
     */
    String BCRYPT = "{bcrypt}";

    String JWT_USER_ID_KEY = "id";

    String JWT_CLIENT_ID_KEY = "client_id";

    /**
     * Gateway接口路径匹配
     */
    String GATEWAY_URL_PATTERN = "/v1/gateway/**";


    String ADMIN_CLIENT_ID = "lens-admin-app";


    /**
     * 小程序客户端ID
     */
    String WEAPP_CLIENT_ID = "lens-wx-app";
}
