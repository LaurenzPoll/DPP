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

            // 1. Fetch the requirement level from the service
            String rawRequirementLevel = fieldDefinitionService.getRequirementLevel(fieldName);
            // Treat null as "Unknown"
            String effectiveRequirementLevel = (rawRequirementLevel == null) ? "Unknown" : rawRequirementLevel;

            // 2. Prepare the result map for this field
            Map<String, String> result = new HashMap<>();
            result.put("requirementLevel", effectiveRequirementLevel);

            // 3. Set compliance and gap based on requirementLevel + fieldValue
            switch (effectiveRequirementLevel.toLowerCase()) {
                case "mandatory" -> {
                    if (fieldValue == null || fieldValue.trim().isEmpty()) {
                        result.put("compliance", "Not Compliant");
                        result.put("gap", "Data not entered: This field is required for compliance");
                    } else {
                        result.put("compliance", "Compliant");
                        result.put("gap", "None");
                    }
                }
                case "voluntary" -> {
                    // For voluntary fields, treat as compliant by default (or add custom logic)
                    result.put("compliance", "Compliant");
                    result.put("gap", "None");
                }
                default -> {
                    // "Unknown" or any unrecognized requirement level
                    result.put("compliance", "Not Compliant");
                    result.put("gap", "Data not entered: This field is required for compliance");
                }
            }

            // 4. Store the result for this field
            complianceResults.put(fieldName, result);
        }

        return complianceResults;

//            String requirementLevel = fieldDefinitionService.getRequirementLevel(fieldName);
//
//            Map<String, String> result = new HashMap<>();
//            if (requirementLevel == null) {
//                result.put("compliance", "Not Compliant");
//                result.put("gap", "Field not provided");
//            } else if ("Voluntary".equalsIgnoreCase(requirementLevel)) {
//                result.put("compliance", "Compliant");
//                result.put("gap", "None");
//            } else if ("Mandatory".equalsIgnoreCase(requirementLevel)) {
//                if (fieldValue == null || fieldValue.trim().isEmpty()) {
//                    result.put("compliance", "Not Compliant");
//                    result.put("gap", "Field not provided");
//                } else {
//                    // TODO
//                    result.put("compliance", "Compliant");
//                    result.put("gap", "None");
//                }
//            }
//            complianceResults.put(fieldName, result);
//        }
//
//        return complianceResults;
    }
}
