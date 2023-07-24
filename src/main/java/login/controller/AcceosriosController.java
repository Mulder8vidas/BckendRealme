package com.example.login.controller;

import com.example.login.entity.Producto;
import com.example.login.models.Accesorios;
import com.example.login.services.AccesoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class AcceosriosController {
    @Autowired
    private AccesoriosService servicio;
    @GetMapping("/Accesorios")
    public List<Accesorios> listarAccesorios(){
        return servicio.listarAccesorios();
    }
    @GetMapping("/Accesorios/{id}")
    public ResponseEntity<Accesorios> obtenerAccesorios(@PathVariable Integer id) {
        try {
            Accesorios accesorios = servicio.obtenerAccesoriosporId(id);
            return new ResponseEntity<Accesorios>(accesorios, HttpStatus.OK);
        } catch (Exception excepcion) {
            return new ResponseEntity<Accesorios>(HttpStatus.NOT_FOUND);
        }
    }
}
