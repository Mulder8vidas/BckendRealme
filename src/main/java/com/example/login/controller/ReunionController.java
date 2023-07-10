package com.example.login.controller;

import com.example.login.models.Reunion.ReunionDO;
import com.example.login.services.reunion.ReunionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reunion")
public class ReunionController {

    private final ReunionService reunionService;

    @Autowired
    public ReunionController(ReunionService reunionService) {
        this.reunionService = reunionService;
    }

    @PostMapping("")
    public ResponseEntity<?> crearReunion(@RequestBody ReunionDO data) {
        return ResponseEntity.ok(this.reunionService.crearReunion(data));
    }

    @GetMapping("/usuarios")
    public List<?> listaUsuarios(){
        return this.reunionService.listaUsuarios();
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> eliminiarUsuarios(@PathVariable int id){
        return ResponseEntity.ok(this.reunionService.eliminarUsuarios(id));
    }
    @GetMapping("")
    public List<?> listaReuniones(){

        return this.reunionService.listaReuniones();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerReunion(@PathVariable int id){
        return ResponseEntity.ok(this.reunionService.obtenerReunion(id));
    }
}
