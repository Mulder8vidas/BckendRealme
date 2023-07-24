package com.example.login.services.reunion;

import com.example.login.entity.*;
import com.example.login.models.ResponseDO;
import com.example.login.models.Reunion.ReunionDO;
import com.example.login.utils.UsersUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReunionService  {

    private final ReunionUsuarioRepository reunionUsuarioRepository;
    private final UsersUtils usersUtils;
    private final ReunionRepository reunionRepository;

    private final AuthRepository authRepository;

    @Autowired
    public ReunionService(ReunionUsuarioRepository reunionUsuarioRepository, UsersUtils usersUtils, ReunionRepository reunionRepository, AuthRepository authRepository) {
        this.reunionUsuarioRepository = reunionUsuarioRepository;
        this.usersUtils = usersUtils;
        this.reunionRepository = reunionRepository;
        this.authRepository = authRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResponseDO<?> crearReunion(ReunionDO data){

        try {
            ReunionEntity reunionEntity = new ReunionEntity();
            reunionEntity.setFechaReunion(data.fechaReunion());
            reunionEntity.setNombreReunion(data.nombreReunion());
            reunionEntity.setActive(true);
            reunionEntity.setTarea(data.tareas());


            ReunionEntity save = this.reunionRepository.save(reunionEntity);

            List<ReunionUsuarioEntity> collect = data.usuarios().stream().map(integer -> this.authRepository.findById(integer).get()).toList().stream().map(authEntity -> {
                ReunionUsuarioEntity reunionUsuarioEntity = new ReunionUsuarioEntity();
                reunionUsuarioEntity.setIdReunion(save);
                reunionUsuarioEntity.setIdUser(authEntity);
                return reunionUsuarioEntity;
            }).collect(Collectors.toList());
            List<ReunionUsuarioEntity> reunionUsuarioEntities = this.reunionUsuarioRepository.saveAll(collect);
            return new ResponseDO<>(true,"Reunion creada con exito",null);
        }catch (Exception ex){
            return new ResponseDO<>(false,ex.getMessage(),null);
        }


    }

    public List<?> listaUsuarios() {

        return this.authRepository.findAll().stream().map(authEntity -> {

            Map<String, Object> data = new HashMap<>();
            data.put("nombre",authEntity.getNombre());
            data.put("apellido",authEntity.getApellido());
            data.put("username",authEntity.getUsername());
            data.put("id",authEntity.getId());
            data.put("selected",false);
            return data;

        }).collect(Collectors.toList());
    }


    public ResponseDO eliminarUsuarios(int id) {

        this.authRepository.deleteById(id);
        return new ResponseDO<>(true,"Reunion eliminada con exito",null);

    }

    public List listaReuniones() {

        return this.reunionRepository.misReuniones(this.usersUtils.getUserCode()).stream().map(reunionEntity -> {
            Map<String,Object> data= new HashMap<>();
            data.put("id",reunionEntity.getId());
            data.put("active",reunionEntity.isActive());
            data.put("fecha",reunionEntity.getFechaReunion());
            data.put("nombre",reunionEntity.getNombreReunion());
            return data;


        }).toList();

    }

    public Map<String,Object> obtenerReunion(int id) {

        ReunionEntity reunionEntity = this.reunionRepository.findById(id).orElseThrow(() -> new RuntimeException("Reunion no encontrada"));

        List<ReunionUsuarioEntity> byIdReunion = this.reunionUsuarioRepository.findByIdReunion(reunionEntity.getId());

        Map<String,Object> data = new HashMap<>();
        data.put("reunion",reunionEntity);
        data.put("participantes",byIdReunion);

        return data;




    }
}
