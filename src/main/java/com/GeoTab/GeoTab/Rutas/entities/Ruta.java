package com.GeoTab.GeoTab.Rutas.entities;

import jakarta.persistence.*;

@Entity
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRuta;
    private String nombre;
    private String descripcion;
    private Long idDemanda;

    // Getters y setters
    public Long getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Long id) {
        this.idRuta = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdDemanda() {
        return idDemanda;
    }

    public void setIdDemanda(Long idDemanda) {
        this.idDemanda = idDemanda;
    }
}
