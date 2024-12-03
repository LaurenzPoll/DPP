package com.example.demo.entity;

import lombok.Data;

@Data
public class InputDate {
         private String batteryName;
         private String batteryType;

    public String getBatteryName() {
        return batteryName;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryName(String batteryName) {
        this.batteryName = batteryName;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }
}
