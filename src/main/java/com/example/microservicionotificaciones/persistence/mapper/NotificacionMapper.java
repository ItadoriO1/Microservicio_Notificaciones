package com.example.microservicionotificaciones.persistence.mapper;

import com.example.microservicionotificaciones.domain.dto.NotificacionDTO;
import com.example.microservicionotificaciones.persistence.entity.Notificacion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {NotificacionMapper.class})
public interface NotificacionMapper {

    //Mapeo de Notificacion a NotificacionDTO
    @Mapping(source = "titulo", target = "titulo")
    @Mapping(source = "canal", target = "canal")
    @Mapping(source = "mensaje", target = "mensaje")
    NotificacionDTO toDTO(Notificacion notificacion);

    //Mapeo inverso
    @InheritInverseConfiguration
    Notificacion toEntity(NotificacionDTO notificacionDTO);
}
