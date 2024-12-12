package com.example.demo.controller;

import com.example.demo.entity.UserRequest;
import jakarta.validation.Valid;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.http.ResponseEntity;


@RestController
@ComponentScan("com.example.demo.Validation")
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public String testEndpoint() {
        return "GET请求已成功到达！";
    }

    @PostMapping("/validate")
    public ResponseEntity<String> submitBatteryForm(@Valid @RequestBody UserRequest userrequest, BindingResult result) {
        if (result.hasErrors()) {
            //将错误信息字符串化，遍历错误信息，表示 HTTP 状态码 400，表示客户端发送的请求有误（通常是表单验证失败等）。
            // 将拼接好的错误消息作为响应体的内容，发送给客户端。这个消息可以帮助客户端理解请求失败的原因。
            StringBuilder errorMessages = new StringBuilder();
            result.getAllErrors().forEach(error -> errorMessages.append(error.getDefaultMessage()).append("\n"));
            return ResponseEntity.badRequest().body(errorMessages.toString());
        }

        // Process the valid batteryForm
        return ResponseEntity.ok("Form submitted successfully!");
    }
}
