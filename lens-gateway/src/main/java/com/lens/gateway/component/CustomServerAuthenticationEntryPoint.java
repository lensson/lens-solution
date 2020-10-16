package com.lens.gateway.component;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-16 1:19 PM
 */

import cn.hutool.json.JSONUtil;
import com.lens.common.core.result.Result;
import com.lens.common.core.result.ResultCode;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.server.ServerAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;

import static com.lens.common.core.constant.HttpConstants.HTTP_HEAD_Access_Control_Allow_Origin;
import static com.lens.common.core.constant.HttpConstants.HTTP_HEAD_Cache_Control;

/**
 * 无效token/token过期 自定义响应
 */
@Component
public class CustomServerAuthenticationEntryPoint implements ServerAuthenticationEntryPoint {

    @Override
    public Mono<Void> commence(ServerWebExchange exchange, AuthenticationException e) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        response.getHeaders().set(HTTP_HEAD_Access_Control_Allow_Origin, "*");
        response.getHeaders().set(HTTP_HEAD_Cache_Control, "no-cache");
        String body = JSONUtil.toJsonStr(Result.custom(ResultCode.TOKEN_INVALID_OR_EXPIRED));
        DataBuffer buffer = response.bufferFactory().wrap(body.getBytes(Charset.forName("UTF-8")));
        return response.writeWith(Mono.just(buffer));
    }

}
