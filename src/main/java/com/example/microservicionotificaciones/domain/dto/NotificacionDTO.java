package com.example.microservicionotificaciones.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificacionDTO {

    private Long id;

    private Long personId;

    @NotBlank(message = "El titulo no puede estar vacio")
    private String titulo;

    @NotBlank(message = "El canal no puede estar vacio")
    private String canal;

    @NotBlank(message = "El mensaje no puede estar vacio")
    private String mensaje;
}
