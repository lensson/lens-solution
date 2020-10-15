package com.lens.auth.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

@JsonSerialize(using = OAuth2ExceptionSerializer.class)
public class CustomOAuth2Exception extends OAuth2Exception {

    @Getter
    private String oAuth2ErrorCode;

    public CustomOAuth2Exception(String msg, String oAuth2ErrorCode) {
        super(msg);
        this.oAuth2ErrorCode = oAuth2ErrorCode;
    }
}