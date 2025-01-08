package com.example.demo.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import com.example.demo.entity.FieldDefinition;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FieldDefinitionService {

    @Autowired
    private ResourceLoader resourceLoader;

    private Map<String, String> fieldRequirements = new HashMap<>();

    @PostConstruct
    public void init() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:field_definitions.json");
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the JSON as a tree
        JsonNode rootNode = objectMapper.readTree(resource.getInputStream());

        // Extract the 'fields' node
        JsonNode fieldsNode = rootNode.get("fields");

        // Convert the 'fields' node to a List<FieldDefinition>
        List<FieldDefinition> fieldDefinitions = objectMapper.convertValue(fieldsNode, new TypeReference<List<FieldDefinition>>() {});

        // Populate the fieldRequirements map
        for (FieldDefinition fieldDefinition : fieldDefinitions) {
            fieldRequirements.put(fieldDefinition.getField(), fieldDefinition.getRequirementLevel());
        }
    }


    public String getRequirementLevel(String fieldName) {
        return fieldRequirements.get(fieldName);
    }
}
