package com.example.login.controller;

import com.example.login.models.Reunion.ChatDO;
import com.example.login.services.NotificacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensaje")
public class MensajesController {


    private final NotificacionesService notificacionesService;

    @Autowired
    public MensajesController(NotificacionesService notificacionesService) {
        this.notificacionesService = notificacionesService;
    }

    @RequestMapping("")
    public void enviarMensaje(@RequestBody ChatDO chatDO){

        this.notificacionesService.mensajeReunion(chatDO.getId(), chatDO.getMensaje());

    }
}
