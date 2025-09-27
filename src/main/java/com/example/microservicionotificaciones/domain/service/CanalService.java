package com.example.microservicionotificaciones.domain.service;

import com.example.microservicionotificaciones.domain.dto.NotificacionDTO;

import java.io.IOException;

public interface CanalService {
    void enviarNotificacion(NotificacionDTO notificacion) throws IOException, InterruptedException;
}
