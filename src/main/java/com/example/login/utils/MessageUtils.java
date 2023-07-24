package com.example.login.utils;

import com.example.login.models.MensajeDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
@Setter

public class MessageUtils {

    private List<MensajeDTO> listaMensajes= new ArrayList<>();


    public void agregarMensaje(MensajeDTO mensajeDTO){
        this.listaMensajes.add(mensajeDTO);
    }
}
