package com.lens.gateway.component;

import cn.hutool.core.util.StrUtil;
import com.lens.common.core.constant.AuthConstants;
import com.lens.gateway.config.WhiteListConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;

/**
 * Desc: 鉴权管理器
 *
 * @author Lens Chen
 * @created 2020-10-16 1:41 PM
 */
@Component
@AllArgsConstructor
@Slf4j
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {

//    private RedisTemplate redisTemplate;

    private WhiteListConfig whiteListConfig;

    private static final AntPathMatcher pathMatcher = new AntPathMatcher();

    private boolean isPermit(String requestPath) {
        return whiteListConfig.getUrls().stream().anyMatch(r -> pathMatcher.match(r,requestPath));
    }

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();


        // 对应跨域的预检请求直接放行
        if (request.getMethod() == HttpMethod.OPTIONS) {
            return Mono.just(new AuthorizationDecision(true));
        }

        String path = request.getURI().getPath();
        if(isPermit(path)){
            return Mono.just(new AuthorizationDecision(true));
        }

        // token为空拒绝访问
        String token = request.getHeaders().getFirst(AuthConstants.JWT_TOKEN_HEADER);
        if (StrUtil.isBlank(token)) {
            return Mono.just(new AuthorizationDecision(false));
        }



        // Only limit Gateway now
        if (!pathMatcher.match(AuthConstants.GATEWAY_URL_PATTERN, path)) {
            return Mono.just(new AuthorizationDecision(true));
        }

        Set<String> authorities = new HashSet<>();
        Mono<AuthorizationDecision> authorizationDecisionMono = mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(roleId -> {
                    // roleId是请求用户的角色(格式:ROLE_{roleId})，authorities是请求资源所需要角色的集合
                    log.info("访问路径：{}", path);
                    log.info("用户角色信息：{}", roleId);
                    log.info("资源需要权限authorities：{}", authorities);
                    return authorities.contains(roleId);
                })
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));



        return authorizationDecisionMono;
    }
}
