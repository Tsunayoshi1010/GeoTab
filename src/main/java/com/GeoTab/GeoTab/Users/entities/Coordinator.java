package com.GeoTab.GeoTab.Users.entities;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "coordinators")
@Data
@AllArgsConstructor
@DiscriminatorValue("COORDINATOR")
public class Coordinator extends User {
    private String nameCoordinator;
    private String idDocument;

    public String getNameCoordinator() {
        return nameCoordinator;
    }

    public void setNameCoordinator(String nameCoordinator) {
        this.nameCoordinator = nameCoordinator;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(String idDocument) {
        this.idDocument = idDocument;
    }

    public Coordinator(String nameCoordinator) {
        this.nameCoordinator = nameCoordinator;
    }

    public Coordinator(Long id, String email, String password, String nameCoordinator) {
        super(id, email, password);
        this.nameCoordinator = nameCoordinator;
    }

    public Coordinator() {
    }
}
