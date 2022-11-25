package com.pilots.DriversAPI.championships.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@Scope("prototype")
public class Championship {

    public String getId() {
        return id;
    }

    final String id;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<DriverResult> getDriverResults() {
        return driverResults;
    }

    public void setDriverResults(List<DriverResult> driverResults) {
        this.driverResults = driverResults;
    }

    String category;
    int year;
    List<DriverResult> driverResults;

    public Championship() {
        this.id = UUID.randomUUID().toString();
    }

    @Autowired
    public Championship(String category, int year) {
        this.id = UUID.randomUUID().toString();
        this.driverResults = new ArrayList();
        this.category = category;
        this.year = year;
    }

    // Use to set static default data for constant ID reference
    @Autowired
    public Championship(String id, String category, int year) {
        this.id = id;
        this.driverResults = new ArrayList();
        this.category = category;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Championship{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", year=" + year +
                ", driverResults=" + driverResults +
                '}';
    }
}
