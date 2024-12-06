package com.GeoTab.GeoTab.Users.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "roles")
@Data
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long identification;
    private String password;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Road> roadList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdentification() {
        return identification;
    }

    public void setIdentification(Long identification) {
        this.identification = identification;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Road> getRoadList() {
        return roadList;
    }

    public void setRoadList(List<Road> roadList) {
        this.roadList = roadList;
    }

    public User(Long id, Long identification, String password, String email, List<Road> roadList) {
        this.id = id;
        this.identification = identification;
        this.password = password;
        this.email = email;
        this.roadList = roadList;
    }

    public User() {
    }

    @Transient
    @JsonProperty("roles")
    public String getRole() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }
}
