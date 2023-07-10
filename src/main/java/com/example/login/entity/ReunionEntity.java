package com.example.login.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "reunion")
@Getter
@Setter
public class ReunionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombreReunion;

    private boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReunion;

    @JsonIgnore
    @OneToMany(targetEntity = ReunionUsuarioEntity.class,mappedBy = "idReunion")
    Set<ReunionUsuarioEntity> usuariosReunion;

    private String tarea;



}
