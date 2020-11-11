package com.lens.blog.base.exception.type;

/**
 * @author Lens Chen
 * @created 2020-11-11 9:54 AM
 * @Description
 */
public class BusinessException extends RuntimeException {

    /**
     * 异常编码
     */
    private String code;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, String code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}