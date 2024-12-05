package com.GeoTab.GeoTab.Rutas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rutas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRuta;
    private String username;
    private String password;
    private String email;
}
