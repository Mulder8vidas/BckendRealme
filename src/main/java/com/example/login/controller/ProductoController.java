package com.example.login.controller;

import com.example.login.entity.Producto;
import com.example.login.services.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class ProductoController {
    @Autowired
    private ProductoServicio servicio;
    @GetMapping("/productos")
    public List<Producto> listarProductos(){
        return servicio.listarProductos();
    }
    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Integer id) {
        try {
            Producto producto = servicio.obtenerProductoPorId(id);
            return new ResponseEntity<Producto>(producto,HttpStatus.OK);
        } catch (Exception excepcion) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/productos")
    public void guardarProductos(@RequestBody Producto producto){
        servicio.guardarProducto(producto);
    }
    @GetMapping("/masvendidos")
    public List<Producto> MasVendidos(){
        return servicio.Masvendisos();
    }

}
