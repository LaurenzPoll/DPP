package com.example.demo.controller;

import com.example.demo.Service.ComplianceService;
import com.example.demo.entity.ValidRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@RestController
@ComponentScan("com.example.demo.Validation")
@RequestMapping("/test")
public class ValidationController {

    private static final Logger logger = LoggerFactory.getLogger(ValidationController.class);

    @Autowired
    private ComplianceService complianceService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:5174")
    public String testEndpoint() {
        return "GET SUCCESS！";
    }

    @PostMapping("/validate")
    @CrossOrigin(origins = "http://localhost:5174")
    public ResponseEntity<Object> submitBatteryForm(@Valid @RequestBody ValidRequest userRequest,
                                                    BindingResult result) {
        // Log the request data
        logger.info("Received request: {}", userRequest);

        if (result.hasErrors()) {
            // Log the validation errors
            StringBuilder errorMessages = new StringBuilder();
            result.getAllErrors().forEach(error -> errorMessages.append(error.getDefaultMessage()).append("\n"));
            logger.error("Validation errors: {}", errorMessages.toString());
            return ResponseEntity.badRequest().body(errorMessages.toString());
        }

        // Create formData
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

        // Log the form data before processing
        logger.info("Form data: {}", formData);

        // Evaluate compliance
        Map<String, Map<String, String>> complianceResults = complianceService.evaluateCompliance(formData);

        // Build the JSON response (same as before)
        List<Map<String, String>> rows = new ArrayList<>();
        complianceResults.forEach((fieldName, resultMap) -> {
            Map<String, String> row = new LinkedHashMap<>();
            row.put("Field", fieldName);
            row.put("Requirement Level", resultMap.get("requirementLevel"));
            row.put("Compliance", resultMap.get("compliance"));
            row.put("Input", formData.get(fieldName));  // the user input
            row.put("Gap", resultMap.get("gap"));
            rows.add(row);
        });

        List<String> columns = List.of("Field", "Requirement Level", "Compliance", "Input", "Gap");
        Map<String, Object> generalInformation = new LinkedHashMap<>();
        generalInformation.put("overall_readiness_level", "99%");  // Hard-coded as requested
        generalInformation.put("columns", columns);
        generalInformation.put("rows", rows);

        Map<String, Object> dppReadinessReport = new LinkedHashMap<>();
        dppReadinessReport.put("General Information", generalInformation);

        Map<String, Object> finalJson = new LinkedHashMap<>();
        finalJson.put("dpp_readiness_report", dppReadinessReport);

        // Log the final response data
        logger.info("Final JSON response: {}", finalJson);

        // Return the response
        return ResponseEntity.ok(finalJson);
    }
}
