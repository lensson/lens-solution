package com.lens.blog.base.exception.type;

import com.lens.blog.base.global.BaseMessageConf;
import com.lens.blog.base.global.ErrorCode;

import java.io.Serializable;

/**
 * @author Lens Chen
 * @created 2020-11-11 9:54 AM
 * @Description
 */
public class DeleteException extends RuntimeException implements Serializable {

    /**
     * 异常状态码
     */
    private String code;

    public DeleteException() {
        super(BaseMessageConf.DELETE_DEFAULT_ERROR);
        this.code = ErrorCode.DELETE_DEFAULT_ERROR;
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
        this.code = ErrorCode.DELETE_DEFAULT_ERROR;
    }

    public DeleteException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public DeleteException(String message) {
        super(message);
        this.code = ErrorCode.DELETE_DEFAULT_ERROR;
    }

    public DeleteException(String code, String message) {
        super(message);
        this.code = code;
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
