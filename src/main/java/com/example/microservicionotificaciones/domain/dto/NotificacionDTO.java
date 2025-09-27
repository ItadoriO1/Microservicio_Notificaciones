package com.example.microservicionotificaciones.domain.dto;

import com.example.microservicionotificaciones.persistence.entity.Canal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionDTO {

    private Long id;

    @NotNull(message = "El ID de la persona no puede ser nulo")
    private Long personId;

    @NotBlank(message = "El titulo no puede estar vacio")
    private String titulo;

    @NotNull(message = "El canal no puede estar vacio")
    private Canal canal;

    @NotBlank(message = "El mensaje no puede estar vacio")
    private String mensaje;
}
