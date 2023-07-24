package com.example.login.services;

import com.example.login.models.MensajeDTO;
import com.example.login.utils.MessageUtils;
import com.example.login.utils.UsersUtils;
import jdk.security.jarsigner.JarSigner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionesService {

    private final String REUNION = "/chat/reunion/";
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    MessageUtils messageUtils;
    @Autowired
    private UsersUtils usersUtils;

    public void mensajeReunion(int reunion, String mensaje) {
        MensajeDTO mensajeDTO = new MensajeDTO();
        mensajeDTO.setMensaje(mensaje);
        mensajeDTO.setIdreunion(reunion);
        mensajeDTO.setUsername(this.usersUtils.getUserCode());
        mensajeDTO.setNombre(this.usersUtils.getNombre());
        this.messageUtils.agregarMensaje(mensajeDTO);
        simpMessagingTemplate.convertAndSend(REUNION + reunion, this.misMensajes(reunion));


    }
    public List<MensajeDTO> misMensajes(int idreunion){
        List<MensajeDTO> listaMensajes = this.messageUtils.getListaMensajes();
        return listaMensajes.stream().filter(mensajeDTO -> mensajeDTO.getIdreunion()==idreunion).toList();
    }
}
