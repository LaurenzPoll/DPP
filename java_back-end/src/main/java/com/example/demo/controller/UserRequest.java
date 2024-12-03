package com.example.demo.controller;

import javax.validation.constraints.*;
import java.util.Date;

public class UserRequest {

    @NotNull(message = "不能为空")
    @Size(min = 1, max = 50, message = "长度应在1到50之间")
    private String name;

    @NotNull(message = "不能为其他字符")
    @Size(min = 1, message = "不能少于1")
    private int word;

    @NotNull(message = "不能为以后的日期")
    private Date date;

    // Getters and Setters

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public int getword() {
        return word;
    }

    public void setword(int word) {
        this.word = word;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
