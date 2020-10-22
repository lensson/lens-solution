package com.lens.common.core.exception;

import com.lens.common.core.result.IResultCode;
import lombok.Getter;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-20 2:58 PM
 */
@Getter
public class LensException extends RuntimeException {

    public IResultCode resultCode;

    public LensException(IResultCode errorCode) {
        super(errorCode.getMsg());
        this.resultCode = errorCode;
    }

    public LensException(String message) {
        super(message);
    }

    public LensException(String message, Throwable cause) {
        super(message, cause);
    }

    public LensException(Throwable cause) {
        super(cause);
    }
}
