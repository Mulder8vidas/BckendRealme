package com.example.login.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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



}
