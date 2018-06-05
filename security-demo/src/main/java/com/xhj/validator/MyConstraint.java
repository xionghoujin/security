package com.xhj.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 熊厚谨 on 2018/5/29 21:25
 *
 * @author 熊厚谨
 */
//作用域
@Target({ElementType.METHOD,ElementType.FIELD})
//声明是运行时的一个注解
@Retention(RetentionPolicy.RUNTIME)
//
@Constraint(validatedBy = MyConstraintValidated.class)
public @interface MyConstraint {
    //每个参数校验的注解都要有这三个属性，@NotBlank、@NotNull..等等
    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};



}
