package com.lens.blog.app.base.validator.constraint;


import com.lens.blog.app.base.validator.annotion.NotBlank;
import com.lens.blog.utils.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * 判断是否为空字符串【校验器】
 *
 * @author 陌溪
 * @date 2019年12月4日13:17:17
 */
public class StringValidator implements ConstraintValidator<NotBlank, String> {
    @Override
    public void initialize(NotBlank constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || StringUtils.isBlank(value) || StringUtils.isEmpty(value.trim())) {
            return false;
        }
        return true;
    }
}
