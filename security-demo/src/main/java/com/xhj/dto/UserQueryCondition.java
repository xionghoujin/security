package com.xhj.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

/**
 * Created by 熊厚谨 on 2018/5/28 15:27
 *
 * @author 熊厚谨
 */
@Data

public class UserQueryCondition {


    private String username;

    private int age;

    private int ageTo;

    private String xxx;
}
