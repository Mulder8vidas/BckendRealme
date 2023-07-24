package com.example.login.services;

import com.example.login.entity.ProductoRepositorio;
import com.example.login.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {
    @Autowired
    private ProductoRepositorio repositorio;
    public List<Producto> listarProductos(){
        return repositorio.findAll();
    }
    public List<Producto> Masvendisos(){
        return repositorio.findAllByMasVendido(true) ;
    }
    public  void  guardarProducto(Producto producto){
        repositorio.save(producto);
    }
    public Producto obtenerProductoPorId(Integer id){
        return repositorio.findById(id).get();
    }
    public void eliminarProducto(Integer id){
        repositorio.deleteById(id);
    }
}
