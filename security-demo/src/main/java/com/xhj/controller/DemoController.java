package com.xhj.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * Created by 熊厚谨 on 2018/5/23 21:49
 *
 * @author 熊厚谨
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @NotNull
    @GetMapping("/hello")
    public String hello() {
        return "hello spring security";
    }
}
