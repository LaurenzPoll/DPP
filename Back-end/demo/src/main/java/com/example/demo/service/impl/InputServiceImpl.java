package com.example.demo.service.impl;
import  com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.InputDate;
import com.example.demo.mapper.InputMapper;
import com.example.demo.service.InputService;
import org.springframework.stereotype.Service;

@Service
public class InputServiceImpl extends ServiceImpl<InputMapper, InputDate> implements InputService {

}
