package com.lens.blog.base.validator.constraint;


import com.lens.blog.base.validator.annotion.Range;
import com.lens.blog.utils.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * 字符串范围约束，限制长度【校验器】
 *
 * @author Lens
 * @date 2019年12月4日13:17:03
 */
public class RangValidator implements ConstraintValidator<Range, String> {
    private long min;
    private long max;

    @Override
    public void initialize(Range constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (null == value || StringUtils.isBlank(value)) {
            return false;
        }
        return value.length() >= min && value.length() <= max;
    }
}
