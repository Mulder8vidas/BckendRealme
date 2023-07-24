package com.example.login.controller;

import com.example.login.services.NotificacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class Message {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private  NotificacionesService notificacionesService;


}
