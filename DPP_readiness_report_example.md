# DPP Readiness Report: Data Loading and Backend Response Structure

This document outlines the JSON structure for handling **Digital Product Passport (DPP) Readiness Reports**. The structure is designed for:
- **Frontend Data Loading**: The frontend uses this JSON to populate the readiness report.
- **Backend Responses**: The backend will send this JSON as part of API responses to provide the necessary data for display.

## JSON Example

```json
{
  "dpp_readiness_report": {
    "General Information": {
      "overall_readiness_level": "50%",
      "columns": [
        "Field",
        "Requirement Level",
        "Compliance",
        "Input",
        "Gap"
      ],
      "rows": [
        {
          "Field": "Battery Passport Identification",
          "Requirement Level": "Mandatory",
          "Compliance": "Not Compliant",
          "Input": "Not provided",
          "Gap": "Field not provided"
        },
        {
          "Field": "Battery Identification",
          "Requirement Level": "Mandatory",
          "Compliance": "Compliant",
          "Input": "Unique ID: BAT-12345",
          "Gap": "None"
        },
        {
          "Field": "Responsible Economic Operator Identifier",
          "Requirement Level": "Mandatory",
          "Compliance": "Partially Compliant",
          "Input": "Identifiers available for 70% of operators",
          "Gap": "Some operators lack unique identifiers."
        },
        {
          "Field": "Manufacturer's Identification",
          "Requirement Level": "Mandatory",
          "Compliance": "Compliant",
          "Input": "Manufacturer ID: MANU-67890",
          "Gap": "None"
        },
        {
          "Field": "Manufacturing Place (manufacturing facility geographical location)",
          "Requirement Level": "Mandatory",
          "Compliance": "Not Compliant",
          "Input": "Not provided",
          "Gap": "Field not provided"
        },
        {
          "Field": "Manufacturing Date (month and year)",
          "Requirement Level": "Mandatory",
          "Compliance": "Not Compliant",
          "Input": "Not provided",
          "Gap": "Field not provided"
        },
        {
          "Field": "Battery category",
          "Requirement Level": "Mandatory",
          "Compliance": "Compliant",
          "Input": "original",
          "Gap": "None"
        },
        {
          "Field": "Weight",
          "Requirement Level": "Voluntary",
          "Compliance": "Compliant",
          "Input": "No weight data recorded",
          "Gap": "None"
        },
        {
          "Field": "Battery Status",
          "Requirement Level": "Mandatory",
          "Compliance": "Not Compliant",
          "Input": "Status field left blank",
          "Gap": "Field not provided"
        }
      ]
    }
  }
}
```

## Explanation of the JSON Structure

### Top-Level Keys
The JSON begins with the **`dpp_readiness_report`**, which holds categories of the report. Each category (e.g., "General Information", "Labels and certifications") contains its own structure and data.

### `General Information`
- Represents a specific category within the product passport (e.g., "General Information", "Labels and certifications").
- Future categories, such as "Carbon footprint" or "Performance & durability" can be added under the same structure.
- Contains the following keys:
    - **`overall_readiness_level`**: Readiness score for this category, expressed as a percentage (e.g., `"50%"`).
    - **`columns`**: Defines the headers of the table for the category.
    - **`rows`**: Contains an array with the data for each field per row within this category.

---

### `overall_readiness_level` Key

The **`overall_readiness_level`** represents the average compliance score for the specific category, expressed as a percentage. It is calculated as follows:

1. **Compliance Scoring**:
  - `"Not Compliant"` = 0
  - `"Partially Compliant"` = 0.5
  - `"Compliant"` = 1

2. **Calculation**:
  - For each field in the category, the compliance score is determined based on its compliance status.
  - The scores are averaged across all fields in the category.
  - The average is then converted into a percentage (e.g., `0.5` → `50%`).

3. **Interpretation**:
  - **`100%`**: Fully compliant; no gaps exist.
  - **Less than `100%`**: Indicates there are fields that still require attention and improvement.

For example:

If a category has 6 fields, and 3 are `"Compliant"`, 2 are `"Not Compliant"`, and 1 is `"Partially Compliant"`, the calculation is:

```Average = (1 + 1 + 1 + 0 + 0 + 0.5) / 6 = 0.58```

This results in: overall_readiness_level = 58%

This methodology provides a clear and actionable overview of the compliance status for each category.


### `columns` Key
Defines the headers of the table:
- **`Field`**: The specific field being assessed (e.g., "Battery Passport Identification").
- **`Requirement Level`**: Indicates whether the field is:
    - **Mandatory**: Legally required.
    - **Voluntary**: Optional but recommended.
- **`Compliance`**: Compliance status, with options:
    - `Compliant`
    - `Partially Compliant`
    - `Not Compliant`
- **`Input`**: The value entered by the company during the assessment (e.g., "Unique ID: BAT-12345").
- **`Gap`**: Standard options include:
    - `"Field not provided"`: For missing fields.
    - `"Field provided but does not meet requirements"`: For partially compliant fields.
    - `"None"`: For fully compliant fields.

    - *This will likely be expanded with other options*

---

### `rows` Key
Contains the specific data for each field within the category. Each row represents:
- The field's compliance information.
- The company's input for that field.
- Any identified gaps and reasoning for the field.
- And other relevant details

Example:
```json
{
  "Field": "Battery Passport Identification",
  "Requirement Level": "Mandatory",
  "Compliance": "Not Compliant",
  "Input": "Not provided",
  "Gap": "Field not provided"
}
```


## All Categories
The following categories can be included in the readiness report:
- General Information
- Labels and Certifications
- Carbon Footprint
- Supply Chain Due Diligence
- Materials and composition
- Performance & Durability
- Circularity & Resource Efficiency

### Adding other categories to existing json

```json
{
  "dpp_readiness_report": {
    "General Information": { ... },
    "Labels and Certifications": { ... },
    "Carbon Footprint": { ... }
  }
}
```