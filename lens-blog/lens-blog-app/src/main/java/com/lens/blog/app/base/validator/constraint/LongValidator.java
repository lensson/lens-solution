package com.lens.blog.app.base.validator.constraint;


import com.lens.blog.app.base.validator.annotion.LongNotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 判断Long是否为空【校验器】
 *
 * @author Lens
 * @date 2019年12月4日13:16:06
 */
public class LongValidator implements ConstraintValidator<LongNotNull, Long> {


    @Override
    public void initialize(LongNotNull constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return true;
    }
}
