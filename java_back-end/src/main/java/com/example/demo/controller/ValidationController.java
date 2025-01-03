package com.example.demo.controller;

import com.example.demo.Service.ComplianceService;
import com.example.demo.entity.ValidRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.http.ResponseEntity;

import java.util.Map;


@RestController
@ComponentScan("com.example.demo.Validation")
@RequestMapping("/test")
public class ValidationController {
    @Autowired
    private ComplianceService complianceService;
    // 注入 ComplianceService
    @GetMapping
    public String testEndpoint() {
        return "GET SUCCESS！";
    }

    @PostMapping("/validate")
    public ResponseEntity<String> submitBatteryForm(@Valid @RequestBody ValidRequest userRequest, BindingResult result) {
        if (result.hasErrors()) {
            // Convert the error messages into a string, iterate through the error details, and indicate HTTP status code 400,
            // which signifies that the client has sent a bad request (usually due to form validation failures, etc.).
            // Send the concatenated error message as the response body to the client. This message will help the client understand the reason for the request failure.
            StringBuilder errorMessages = new StringBuilder();
            result.getAllErrors().forEach(error -> errorMessages.append(error.getDefaultMessage()).append("\n"));
            return ResponseEntity.badRequest().body(errorMessages.toString());
        }
        // 从 ValidRequest 中获取表单数据
        Map<String, String> formData = Map.of(
                "Battery Passport Identification", userRequest.getBatteryPassportIdentification(),
                "Battery Identification", userRequest.getBatteryIdentification(),
                "Responsible Economic Operator Identifier", userRequest.getResponsibleEconomicOperatorIdentifier(),
                "Manufacturer's Identification", userRequest.getManufacturersIdentification(),
                "Manufacturing Place", userRequest.getManufacturingPlace(),
                "Manufacturing Date", userRequest.getManufacturingDate(),
                "Battery Category", userRequest.getBatteryCategory(),
                "Weight", String.valueOf(userRequest.getWeight()),
                "Battery Status", userRequest.getBatteryStatus()
        );

        // 调用 ComplianceService 评估合规性
        Map<String, Map<String, String>> complianceResults = complianceService.evaluateCompliance(formData);

        // 将合规性评估结果拼接成响应信息
        StringBuilder resultMessage = new StringBuilder();
        complianceResults.forEach((fieldName, resultMap) -> {
            resultMessage.append(fieldName)
                    .append(": Compliance = ")
                    .append(resultMap.get("compliance"))
                    .append(", Gap = ")
                    .append(resultMap.get("gap"))
                    .append("\n");
        });

        // 返回合规性评估结果
        return ResponseEntity.ok(resultMessage.toString());
    }

}
