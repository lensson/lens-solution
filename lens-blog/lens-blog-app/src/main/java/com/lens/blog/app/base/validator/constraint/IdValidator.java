package com.lens.blog.app.base.validator.constraint;


import com.lens.blog.app.base.global.Constants;
import com.lens.blog.app.base.validator.annotion.IdValid;
import com.lens.blog.utils.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * ID校验器，主要判断是否为空，并且长度是否为32
 *
 * @author 陌溪
 * @date 2019年12月4日22:48:43
 */
public class IdValidator implements ConstraintValidator<IdValid, String> {


    @Override
    public void initialize(IdValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || StringUtils.isBlank(value) || StringUtils.isEmpty(value.trim()) || value.length() != Constants.THIRTY_TWO) {
            return false;
        }
        return true;
    }
}
