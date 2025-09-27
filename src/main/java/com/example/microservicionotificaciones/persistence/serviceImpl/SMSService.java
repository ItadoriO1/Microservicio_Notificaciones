package com.example.microservicionotificaciones.persistence.serviceImpl;

import com.example.microservicionotificaciones.domain.dto.NotificacionDTO;
import com.example.microservicionotificaciones.domain.service.CanalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@Service("SMS")
public class SMSService implements CanalService {

    // Inyección de credenciales de seguridad desde properties/variables de entorno
    @Value("${rapidapi.key}")
    private String rapidApiKey;

    @Value("${rapidapi.host}")
    private String rapidApiHost;

    // Placeholder para el número de teléfono (debe ser dinámico en una aplicación real)
    private static final String DESTINATION_NUMBER = "+573225661208";

    @Override
    public void enviarNotificacion(NotificacionDTO notificacion) throws IOException, InterruptedException {
        log.info("Enviando SMS a persona {}: {}", notificacion.getPersonId(), notificacion.getMensaje());

        // Construye el cuerpo JSON dinámicamente con el mensaje del DTO
        String jsonBody = String.format("{\"phone_number\":\"%s\",\"text\":\"%s\"}", DESTINATION_NUMBER, notificacion.getMensaje());

        HttpRequest request = HttpRequest.newBuilder()
                // Construye la URL usando la variable inyectada
                .uri(URI.create("https://" + rapidApiHost + "/sms"))

                // Usa las variables inyectadas para autenticación
                .header("x-rapidapi-key", rapidApiKey)
                .header("x-rapidapi-host", rapidApiHost)

                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        // Logs de la respuesta para verificar el éxito (esperar 200 o 202)
        log.info("Respuesta de RapidAPI - Status Code: {}", response.statusCode());
        log.info("Response Body: {}", response.body());
    }
}