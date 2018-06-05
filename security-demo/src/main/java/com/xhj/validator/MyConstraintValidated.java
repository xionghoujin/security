package com.xhj.validator;

import com.xhj.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by 熊厚谨 on 2018/5/29 21:29
 *
 * @author 熊厚谨
 */
//需要实现ConstraintValidator接口 泛型的第一个参数意思是校验哪个注解，
// 第二个意思是校验的参数的类型是什么类型的（因为注解作用在字段上所以意思是字段的类型）
public class MyConstraintValidated implements ConstraintValidator<MyConstraint,Object> {
    @Autowired
    private HelloService helloService;

    //初始化时会被调用的方法，可以进行一些初始化操作
    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("my validator init");
    }
    //真正的校验逻辑 第一个参数是被校验的值，第二个参数是校验的上下文，包含注解中的值
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {

        //一般对被验证的参数做一些判断

        helloService.greeting("tom");
        System.out.println(value);
        return false;
    }

}
