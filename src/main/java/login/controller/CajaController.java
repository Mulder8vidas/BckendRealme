package com.example.login.controller;

import com.example.login.models.EntradaData;
import com.example.login.services.CajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/caja")
public class CajaController {


    @Autowired
    private CajaService cajaService;

    @PostMapping("")
    public List  dataCalculada(@RequestBody EntradaData data){


        return this.cajaService.calcularCaja(data);
    }
}
