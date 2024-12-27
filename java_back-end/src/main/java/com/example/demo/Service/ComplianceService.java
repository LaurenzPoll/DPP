package com.example.demo.Service;

import com.example.demo.Service.FieldDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ComplianceService {

    @Autowired
    private FieldDefinitionService fieldDefinitionService;
    /*
    * This code snippet evaluates whether a field complies
    * with certain requirements based on the values of
    *  requirementLevel and fieldValue,
    *  and stores the result in a result dictionary,
    *  which is then added to complianceResults. */

    public Map<String, Map<String, String>> evaluateCompliance(Map<String, String> formData) {
        Map<String, Map<String, String>> complianceResults = new HashMap<>();

        for (Map.Entry<String, String> entry : formData.entrySet()) {
            String fieldName = entry.getKey();
            String fieldValue = entry.getValue();
            String requirementLevel = fieldDefinitionService.getRequirementLevel(fieldName);

            Map<String, String> result = new HashMap<>();
            if (requirementLevel == null) {
                result.put("compliance", "Not Compliant");
                result.put("gap", "Field not provided");
            } else if ("Voluntary".equalsIgnoreCase(requirementLevel)) {
                result.put("compliance", "Compliant");
                result.put("gap", "Null");
            } else if ("Mandatory".equalsIgnoreCase(requirementLevel)) {
                if (fieldValue == null || fieldValue.trim().isEmpty()) {
                    result.put("compliance", "Not Compliant");
                    result.put("gap", "Field not provided");
                } else {
                    // TODO
                    result.put("compliance", "Compliant");
                    result.put("gap", "Null");
                }
            }
            complianceResults.put(fieldName, result);
        }

        return complianceResults;
    }
}
