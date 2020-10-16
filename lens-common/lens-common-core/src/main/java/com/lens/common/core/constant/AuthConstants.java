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
     * Gateway接口路径匹配
     */
    String GATEWAY_URL_PATTERN ="/v1/gateway/**" ;

}
