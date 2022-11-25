package com.pilots.DriversAPI.drivers.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@Scope("prototype")
public class Driver {
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getId() {
        return id;
    }

    final String id;
    String lastName;
    String firstName;
    String birthDate;
    String country;

    public Driver() {
        this.id = UUID.randomUUID().toString();
    }

    @Autowired
    public Driver(String lastName, String firstName, String birthDate, String country) {
        setLastName(lastName);
        setFirstName(firstName);
        setBirthDate(birthDate);
        setCountry(country);
        this.id = UUID.randomUUID().toString();
    }

    // Use to set static default data for constant ID reference
    @Autowired
    public Driver(String id, String lastName, String firstName, String birthDate, String country) {
        setLastName(lastName);
        setFirstName(firstName);
        setBirthDate(birthDate);
        setCountry(country);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
