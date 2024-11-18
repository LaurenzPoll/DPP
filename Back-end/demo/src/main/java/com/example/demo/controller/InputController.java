package com.example.demo.controller;

import com.example.demo.service.InputService;
import com.example.demo.entity.InputDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class InputController {

    public InputDate InputDate;

    // 显示输入页面
   @GetMapping
    public String hello(){return"hello world";}

    @Autowired
    private InputService inputService;

    @GetMapping("/list")
    public String list(){
        InputDate inputDate=new InputDate();
        inputDate.setBatteryName("NanFu");
        inputDate.setBatteryType("small");
        String date=inputDate.getBatteryName()+inputDate.getBatteryType();

         return date;
    }}

