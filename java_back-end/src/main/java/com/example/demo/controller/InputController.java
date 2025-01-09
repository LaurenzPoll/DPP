package com.example.demo.controller;

import com.example.demo.entity.InputDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan("com.example.demo.entity")
//请求处理类
@RequestMapping
//注解类
public class InputController {

    public InputDate InputDate;

    // 显示输入页面
   @GetMapping
   @CrossOrigin(origins = "http://localhost:5174")
    public String hello(){return"hello world";}

//    @Autowired

    @PostMapping("/list")
    @CrossOrigin(origins = "http://localhost:5174")
    public String list(){
        InputDate inputDate=new InputDate();
        inputDate.setBatteryName("NanFu");
        inputDate.setBatteryType("small");

         return inputDate.getBatteryName()+inputDate.getBatteryType();
    }}

