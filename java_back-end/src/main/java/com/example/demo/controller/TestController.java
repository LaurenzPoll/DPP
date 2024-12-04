package com.example.demo.controller;
import com.example.demo.entity.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@ComponentScan("com.example.demo.Validation")
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public String testEndpoint() {
        return "GET请求已成功到达！";
    }

    @PostMapping("/validate")
    public String validateUserRequest(@RequestBody @Valid UserRequest userRequest) {
        // 调用 ParameterValidator 进行参数验证
        return "success！！！！";
    }
}
