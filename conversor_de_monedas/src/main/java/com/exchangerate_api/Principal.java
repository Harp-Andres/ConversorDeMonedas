package com.exchangerate_api;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        SolicitudClienteHTTP solicitudClienteHTTP = new SolicitudClienteHTTP();
        RespuestaHTTP respuestaHTTP = new RespuestaHTTP();
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el codigo de la moneda que quiere consultar:");
        try {
            var codigoMoneda = lectura.nextLine();
            HttpRequest solicitud = solicitudClienteHTTP.construirPeticion(codigoMoneda);
            System.out.println(solicitud);
            HttpResponse<String> respuesta = solicitudClienteHTTP.enviarPeticion(solicitud);
            ConversionMoneda conversion = respuestaHTTP.procesarRespuesta(respuesta);
            System.out.println("Tasa de cambio: " + conversion);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(conversion);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizo la aplicación.");
        }
    }
}
