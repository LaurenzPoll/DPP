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
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;


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
    public ResponseEntity<Object> submitBatteryForm(@Valid @RequestBody ValidRequest userRequest,
                                                                 BindingResult result) {
        if (result.hasErrors()) {
            // Convert the error messages into a string, iterate through the error details, and indicate HTTP status code 400,
            // which signifies that the client has sent a bad request (usually due to form validation failures, etc.).
            // Send the concatenated error message as the response body to the client. This message will help the client understand the reason for the request failure.
            StringBuilder errorMessages = new StringBuilder();
            result.getAllErrors().forEach(error -> errorMessages.append(error.getDefaultMessage()).append("\n"));
            return ResponseEntity.badRequest().body(errorMessages.toString());
        }

        // 1. Create formData (key = "display name", value = "user input") to pass to the compliance service
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

        // 2. Evaluate compliance; complianceResults should map each field to a Map of { "requirementLevel", "compliance", "gap" }
        Map<String, Map<String, String>> complianceResults = complianceService.evaluateCompliance(formData);

        // 3. Build the JSON structure dynamically
        //    Outer layer: { "dpp_readiness_report": { "General Information": { ... } } }

        // 3a) "rows" -> each element has: Field, Requirement Level, Compliance, Input, Gap
        List<Map<String, String>> rows = new ArrayList<>();
        complianceResults.forEach((fieldName, resultMap) -> {
            Map<String, String> row = new LinkedHashMap<>();
            row.put("Field", fieldName);
            row.put("Requirement Level", resultMap.get("requirementLevel")); // or wherever you store it
            row.put("Compliance", resultMap.get("compliance"));
            row.put("Input", formData.get(fieldName));  // the user input
            row.put("Gap", resultMap.get("gap"));
            rows.add(row);
        });

        // 3b) "columns" -> from the spec
        List<String> columns = List.of("Field", "Requirement Level", "Compliance", "Input", "Gap");

        // 3c) Build the "General Information" node
        Map<String, Object> generalInformation = new LinkedHashMap<>();
        generalInformation.put("overall_readiness_level", "99%");  // Hard-coded as requested
        generalInformation.put("columns", columns);
        generalInformation.put("rows", rows);

        // 3d) Wrap "General Information" under "dpp_readiness_report"
        Map<String, Object> dppReadinessReport = new LinkedHashMap<>();
        dppReadinessReport.put("General Information", generalInformation);

        // 3e) Final JSON: { "dpp_readiness_report": { ... } }
        Map<String, Object> finalJson = new LinkedHashMap<>();
        finalJson.put("dpp_readiness_report", dppReadinessReport);

        // 4. Return as JSON (Jackson will automatically serialize the Map)
        return ResponseEntity.ok(finalJson);

//        StringBuilder resultMessage = new StringBuilder();
//        complianceResults.forEach((fieldName, resultMap) -> {
//            resultMessage.append(fieldName)
//                    .append(": Compliance = ")
//                    .append(resultMap.get("compliance"))
//                    .append(", Gap = ")
//                    .append(resultMap.get("gap"))
//                    .append("\n");
//        });
//
//        // 返回合规性评估结果
//        return ResponseEntity.ok(resultMessage.toString());
    }

}
