package com.xhj.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.xhj.dto.User;
import com.xhj.dto.UserQueryCondition;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 熊厚谨 on 2018/5/28 14:35
 *
 * @author 熊厚谨
 */
//标注此controller提供RestAPI
@RestController
@RequestMapping("/user")
@EnableSwagger2
public class UserController {
    //映射http请求url到java方法上
//    @RequestParam(required = false,name = "username",defaultValue = "xhj") 方法参数有关的注解 可以设置各种属性
//    @PageableDefault(page = 2,size = 17,sort = "username,asc"  ) 分页有关的注解，设置默认属性，如果未传递则使用
    @JsonView(User.UserSimpleView.class)
    @GetMapping
    public List<User> query( UserQueryCondition condition, @PageableDefault(page = 2,size = 17,sort = "username,asc"  ) Pageable pageable) {

        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        //通过反射输出对象的toString内容
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.DEFAULT_STYLE));
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }
    @GetMapping(value = "{id:\\d+}")
//    PathVariable 这个注解可以将url中的一个片段(数据) 映射到方法的参数上
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id) {
//        throw new UserNotExistException(id);
        System.out.println("进入getInfo服务");
        User user = new User();
        user.setUsername("tom");
        return user;
    }
    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
        }

        System.out.println(user.getId());
            System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }
    @PutMapping(value = "{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
//                FieldError fieldError = (FieldError) error;
//                String message = fieldError.getField() + " " + error.getDefaultMessage();
                System.out.println(error.getDefaultMessage());
            });
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @DeleteMapping(value = "{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }

}
