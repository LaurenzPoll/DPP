package com.example.demo.controller;

import com.example.demo.Validation.ParameterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan("com.example.demo.Validation")
@RequestMapping("/test")
public class TestController {
    @Qualifier("parameter")
    @Autowired

    private ParameterValidator parameterValidator;

    @PostMapping("/validate")
    public String validateUserRequest(@RequestBody UserRequest userRequest) {
        // 调用 ParameterValidator 进行参数验证
        parameterValidator.validate(userRequest);
        return "输入有效！";
    }
}
