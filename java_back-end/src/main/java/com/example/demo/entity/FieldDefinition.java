package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FieldDefinition {
    @JsonProperty("Field")
    private String field;
    @JsonProperty("Requirement Level")
    private String requirementLevel;

    // Getters and setters
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getRequirementLevel() {
        return requirementLevel;
    }

    public void setRequirementLevel(String requirementLevel) {
        this.requirementLevel = requirementLevel;
    }
}
