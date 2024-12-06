package com.GeoTab.GeoTab.Users.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "drivers")
@Data
@DiscriminatorValue("DRIVER")
public class Driver extends User{
    private String nameDriver;
    private String licenseNumber;
    private String licenseCategory;
    private LocalDate licenseIssuanceDate;
    private LocalDate licenseExpirationDate;

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

    public String getLicenseCategory() {
        return licenseCategory;
    }

    public void setLicenseCategory(String licenseCategory) {
        this.licenseCategory = licenseCategory;
    }

    public LocalDate getLicenseIssuanceDate() {
        return licenseIssuanceDate;
    }

    public void setLicenseIssuanceDate(LocalDate licenseIssuanceDate) {
        this.licenseIssuanceDate = licenseIssuanceDate;
    }

    public LocalDate getLicenseExpirationDate() {
        return licenseExpirationDate;
    }

    public void setLicenseExpirationDate(LocalDate licenseExpirationDate) {
        this.licenseExpirationDate = licenseExpirationDate;
    }

    public Driver(Long id, Long identification, String password, String email, List<Road> roadList,
                  String nameDriver, String licenseNumber, String licenseCategory,
                  LocalDate licenseIssuanceDate, LocalDate licenseExpirationDate) {
        super(id, identification, password, email, roadList);
        this.nameDriver = nameDriver;
        this.licenseNumber = licenseNumber;
        this.licenseCategory = licenseCategory;
        this.licenseIssuanceDate = licenseIssuanceDate;
        this.licenseExpirationDate = licenseExpirationDate;
    }

    public Driver(String nameDriver, String licenseNumber, String licenseCategory,
                  LocalDate licenseIssuanceDate, LocalDate licenseExpirationDate) {
        this.nameDriver = nameDriver;
        this.licenseNumber = licenseNumber;
        this.licenseCategory = licenseCategory;
        this.licenseIssuanceDate = licenseIssuanceDate;
        this.licenseExpirationDate = licenseExpirationDate;
    }

    public Driver() {
    }
}
