package com.example.login.services;

import com.example.login.entity.AccesoriosRepositorio;
import com.example.login.entity.Producto;
import com.example.login.entity.ProductoRepositorio;
import com.example.login.models.Accesorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccesoriosService {
    @Autowired
    private AccesoriosRepositorio repositorio;

    public List<Accesorios> listarAccesorios() {
        return repositorio.findAll();
    }

    public void guardarAccesorios(Accesorios accesorios) {
        repositorio.save(accesorios);
    }

    public Accesorios obtenerAccesoriosporId(Integer id) {
        return repositorio.findById(id).get();
    }
    public void eliminarAccesorios(Integer id){
        repositorio.deleteById(id);
    }
}