package com.example.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {

    public Map<String, Object> generateDppReadinessReport() {
        // 初始化 JSON 结构
        Map<String, Object> report = new HashMap<>();
        Map<String, Object> generalInfo = new HashMap<>();

        // 设置 General Information
        generalInfo.put("overall_readiness_level", "50%");
        generalInfo.put("columns", List.of("Field", "Requirement Level", "Compliance", "Input", "Gap"));

        // 设置 rows 数据
        List<Map<String, String>> rows = List.of(
                Map.of("Field", "Battery Passport Identification", "Requirement Level", "Mandatory", "Compliance", "Not Compliant", "Input", "Not provided", "Gap", "Field not provided"),
                Map.of("Field", "Battery Identification", "Requirement Level", "Mandatory", "Compliance", "Compliant", "Input", "Unique ID: BAT-12345", "Gap", "None"),
                Map.of("Field", "Responsible Economic Operator Identifier", "Requirement Level", "Mandatory", "Compliance", "Partially Compliant", "Input", "Identifiers available for 70% of operators", "Gap", "Some operators lack unique identifiers."),
                Map.of("Field", "Manufacturer's Identification", "Requirement Level", "Mandatory", "Compliance", "Compliant", "Input", "Manufacturer ID: MANU-67890", "Gap", "None"),
                Map.of("Field", "Manufacturing Place (manufacturing facility geographical location)", "Requirement Level", "Mandatory", "Compliance", "Not Compliant", "Input", "Not provided", "Gap", "Field not provided"),
                Map.of("Field", "Manufacturing Date (month and year)", "Requirement Level", "Mandatory", "Compliance", "Not Compliant", "Input", "Not provided", "Gap", "Field not provided"),
                Map.of("Field", "Battery category", "Requirement Level", "Mandatory", "Compliance", "Compliant", "Input", "original", "Gap", "None")
        );

        generalInfo.put("rows", rows);
        report.put("dpp_readiness_report", generalInfo);

        return report;
    }
}