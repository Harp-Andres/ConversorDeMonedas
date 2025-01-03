package com.exchangerate_api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Clase para construir solicitudes HTTP
public class SolicitudClienteHTTP {

    private final HttpClient client;

    public SolicitudClienteHTTP() {
        this.client = HttpClient.newHttpClient();
    }

    public HttpRequest construirPeticion(String moneda) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"
                + Constantes.API_KEY + "/latest/" + moneda);

        return HttpRequest.newBuilder()
                .uri(direccion)
                .build();
    }

    public HttpResponse<String> enviarPeticion(HttpRequest request) {

        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al enviar la petición HTTP" ,e);
        }

    }
}
