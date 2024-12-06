package com.GeoTab.GeoTab.Users.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "drivers")
@Data
@AllArgsConstructor
@DiscriminatorValue("DRIVER")
public class Driver extends User{
    private String nameDriver;
    private String licenseNumber;

    public String getNameDriver() {
        return nameDriver;
    }

    public void setNameDriver(String nameDriver) {
        this.nameDriver = nameDriver;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Driver(Long id, String email, String password, String nameDriver, String licenseNumber) {
        super(id, email, password);
        this.nameDriver = nameDriver;
        this.licenseNumber = licenseNumber;
    }

    public Driver(String nameDriver, String licenseNumber) {
        this.nameDriver = nameDriver;
        this.licenseNumber = licenseNumber;
    }

    public Driver() {
    }
}
