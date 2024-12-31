package com.exchangerate_api;

import com.google.gson.Gson;

import java.net.http.HttpResponse;

// Clase para procesar la respuesta HTTP
public class RespuestaHTTP {

    public ConversionMoneda procesarRespuesta(HttpResponse<String> response) {
        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en la respuesta HTTP: " + response.statusCode());
        }

        try {
            return new Gson().fromJson(response.body(), ConversionMoneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al procesar la respuesta JSON", e);
        }
    }
}
