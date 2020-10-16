package com.lens.common.core.result;

import lombok.Data;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-16 1:14 PM
 */
@Data
public class PageResult<T> extends Result {

    private long total;

    public static <T> PageResult<T> success(T data, Long total) {
        PageResult<T> pageResult = new PageResult();
        pageResult.setCode(ResultCode.SUCCESS.getCode());
        pageResult.setMsg(ResultCode.SUCCESS.getMsg());
        pageResult.setData(data);
        pageResult.setTotal(total);
        return pageResult;
    }

}
