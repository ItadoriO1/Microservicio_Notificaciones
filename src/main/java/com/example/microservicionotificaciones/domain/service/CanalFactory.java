package com.example.microservicionotificaciones.domain.service;

import com.example.microservicionotificaciones.persistence.entity.Canal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CanalFactory {

    @Autowired
    private ApplicationContext context;

    public CanalService getService(Canal canal) {
        return context.getBean(canal.name(), CanalService.class);
    }
}
