package com.example.demo.controller;

import com.example.demo.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/report")
public class InputController {

    private final ReportService reportService;

    public InputController() {
        this.reportService = new ReportService();
    }

    @GetMapping("/dpp-readiness")
    public ResponseEntity<Map<String, Object>> getDppReadinessReport() {
        Map<String, Object> report = reportService.generateDppReadinessReport();
        return ResponseEntity.ok(report);
    }
}