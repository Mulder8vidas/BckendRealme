package com.example.login.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
    List<Producto> findAllByMasVendido(boolean activo);
}

