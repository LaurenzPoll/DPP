package com.example.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.*;
import java.util.Date;
@Data
public class UserRequest {

    @NotNull(message = "不能为空")
    @Size(min = 1, max = 50, message = "长度应在1到50之间")
    private String name;

    @NotNull(message = "不能为空")
    @Size(min = 1, message = "不能少于1")
    private int word;

    @NotNull(message = "不能为空")
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWord() {
        return word;
    }

    public void setWord(int word) {
        this.word = word;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
