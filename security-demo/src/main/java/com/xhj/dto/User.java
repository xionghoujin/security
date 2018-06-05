package com.xhj.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.xhj.validator.MyConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by 熊厚谨 on 2018/5/28 14:41
 *
 * @author 熊厚谨
 */
@Data
public class User {

    public interface UserSimpleView {}

    public interface UserDetailView extends UserSimpleView {}

    @JsonView(UserSimpleView.class)
    private String id;
    @MyConstraint(message = "这是一个测试")
    @JsonView(UserSimpleView.class)
    private String username;

    @NotBlank(message = "密码不能为空")
    @JsonView(UserDetailView.class)
    private String password;
    @Past(message = "生日不能为空")
    @JsonView(UserSimpleView.class)
    public Date birthday;
}
