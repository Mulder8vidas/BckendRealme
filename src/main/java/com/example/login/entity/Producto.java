package com.example.login.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int precio;
    private String urlImagen;
    private boolean masVendido;
    private String Descripcion ;
    private String Procesador;
    private String Ram;
    private String Rom;
    private String Camara;
    private String Bateria;
    private String Pantalla;

}
