package com.xhj.service.impl;

import com.xhj.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * Created by 熊厚谨 on 2018/5/29 21:38
 *
 * @author 熊厚谨
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello" + name;
    }
}
