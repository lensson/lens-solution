package com.lens.blog.base.exception.type;

import com.lens.blog.base.global.BaseMessageConf;
import com.lens.blog.base.global.ErrorCode;

import java.io.Serializable;

/**
 * @author Lens Chen
 * @created 2020-11-11 9:55 AM
 * @Description
 */
public class UpdateException extends RuntimeException implements Serializable {
    /**
     * 异常状态码
     */
    private String code;

    public UpdateException() {
        super(BaseMessageConf.UPDATE_DEFAULT_ERROR);
        this.code = ErrorCode.UPDATE_DEFAULT_ERROR;
    }

    public UpdateException(String message, Throwable cause) {
        super(message, cause);
        this.code = ErrorCode.UPDATE_DEFAULT_ERROR;
    }

    public UpdateException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public UpdateException(String message) {
        super(message);
        this.code = ErrorCode.UPDATE_DEFAULT_ERROR;
    }

    public UpdateException(String code, String message) {
        super(message);
        this.code = code;
    }

    public UpdateException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
