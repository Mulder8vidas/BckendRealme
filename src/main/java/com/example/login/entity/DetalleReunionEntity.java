package com.example.login.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "detalle_reuniones")
@Getter
@Setter
public class DetalleReunionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = ReunionEntity.class)
    @JoinColumn(name = "id_reunion")
    private ReunionEntity idReunion;


    @ManyToOne(targetEntity = AuthEntity.class)
    @JoinColumn(name = "id_usuario")
    private AuthEntity idUser;

    @Column(columnDefinition = "TEXT")
    private String actividades;

}
