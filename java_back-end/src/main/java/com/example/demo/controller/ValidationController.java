package com.example.demo.controller;

import com.example.demo.entity.ValidRequest;
import jakarta.validation.Valid;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.http.ResponseEntity;


@RestController
@ComponentScan("com.example.demo.Validation")
@RequestMapping("/test")
public class ValidationController {
    @GetMapping
    public String testEndpoint() {
        return "GET请求已成功到达！";
    }

    @PostMapping("/validate")
    public ResponseEntity<String> submitBatteryForm(@Valid @RequestBody ValidRequest userrequest, BindingResult result) {
        if (result.hasErrors()) {
            // Convert the error messages into a string, iterate through the error details, and indicate HTTP status code 400,
            // which signifies that the client has sent a bad request (usually due to form validation failures, etc.).
            // Send the concatenated error message as the response body to the client. This message will help the client understand the reason for the request failure.
            StringBuilder errorMessages = new StringBuilder();
            result.getAllErrors().forEach(error -> errorMessages.append(error.getDefaultMessage()).append("\n"));
            return ResponseEntity.badRequest().body(errorMessages.toString());
        }

        // Process the valid batteryForm
        return ResponseEntity.ok("Form submitted successfully!");
    }
}
