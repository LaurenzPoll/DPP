package com.example.demo.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ValidRequest {
    @Valid
    @NotEmpty(message = "Battery Passport Identification cannot be empty")
    private String batteryPassportIdentification;
    @Valid
    @NotEmpty(message = "Battery Identification cannot be empty")
    private String batteryIdentification;
    @Valid
    @NotEmpty(message = "Responsible Economic Operator Identifier cannot be empty")
    private String responsibleEconomicOperatorIdentifier;
    @Valid
    @NotEmpty(message = "Manufacturer's Identification cannot be empty")
    private String manufacturersIdentification;
    @Valid
    @NotEmpty(message = "Manufacturing Place cannot be empty")
    private String manufacturingPlace;
    @Valid
    @Pattern(
            regexp = "^(0[1-9]|1[0-2])/(20\\d{2})$",
            message = "Manufacturing Date must be in MM/YYYY format"
    )
    //错误处理
//    @DateConstraint(message = "Manufacturing Date cannot be in the future or invalid")
    private String manufacturingDate;
    @Valid
    @NotEmpty(message = "Battery Category cannot be empty")
    private String batteryCategory;
    @Valid
    @DecimalMin(value = "0.0", message = "Weight must be a positive number")
    private double weight;
    @Valid
    @NotEmpty(message = "Battery Status cannot be empty")
    private String batteryStatus;

//    public boolean isValidManufacturingDate() {
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
//        try {
//            Date date = sdf.parse(manufacturingDate);
//            if (date.after(new Date())) {
//                return false; // Date can't be in the future
//            }
//        } catch (ParseException e) {
//            return false; // Invalid date format
//        }
//        return true;
//    }
// Method to convert the object to a Map
//public Map<String, String> toFormDataMap() {
//    Map<String, String> formData = new HashMap<>();
//    formData.put("field1", getBatteryPassportIdentification());
//    formData.put("field2", getBatteryIdentification());
//    formData.put("field3", getResponsibleEconomicOperatorIdentifier());
//    formData.put("field4", getManufacturersIdentification());
//    formData.put("field5", getManufacturingPlace());
//    formData.put("field6", getManufacturingDate());
//    formData.put("field7", getBatteryCategory());
//    formData.put("field8", String.valueOf(getWeight()));
//    formData.put("field9", getBatteryStatus());
//    return formData;
//}
}
