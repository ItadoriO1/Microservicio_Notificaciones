package com.example.microservicionotificaciones.domain.service;

import com.example.microservicionotificaciones.domain.dto.NotificacionDTO;
import java.util.Optional;

public interface NotificacionService {

    Iterable<NotificacionDTO> findAll();

    NotificacionDTO findById(Long id);

    NotificacionDTO save(NotificacionDTO notificacionDTO);

    void deleteById(Long id);

    long countNotificaciones();

    Iterable<NotificacionDTO> findAllByUsuarioId(Long id);
}
