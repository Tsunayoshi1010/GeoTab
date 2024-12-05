package com.GeoTab.GeoTab.Vehiculos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehiculos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehiculo;
    private String username;
    private String password;
    private String email;
}
