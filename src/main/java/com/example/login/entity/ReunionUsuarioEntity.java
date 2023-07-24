package com.example.login.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "reunion_usuarios")
@Getter
@Setter
public class ReunionUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @JsonIgnore
    @ManyToOne(targetEntity = ReunionEntity.class)
    @JoinColumn(name = "id_reunion")
    private ReunionEntity idReunion;



    @ManyToOne(targetEntity = AuthEntity.class)
    @JoinColumn(name = "id_user")
    private AuthEntity idUser;

}
