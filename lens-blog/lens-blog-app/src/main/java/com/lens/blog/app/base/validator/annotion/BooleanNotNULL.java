package com.lens.blog.app.base.validator.annotion;


import com.lens.blog.app.base.validator.Messages;
import com.lens.blog.app.base.validator.constraint.BooleanValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * 判断Boolean类型是否为空【注解】
 *
 * @author: Lens
 * @date: 2019年12月4日13:12:52
 */
@Target({TYPE, ANNOTATION_TYPE, FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {BooleanValidator.class})
public @interface BooleanNotNULL {

    boolean required() default true;

    String message() default Messages.CK_NOT_NULL_DEFAULT;

    String value() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
