package com.exchangerate_api;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Bienvenido a su conversor de monedas Online!!!");
        SolicitudClienteHTTP solicitudClienteHTTP = new SolicitudClienteHTTP();
        RespuestaHTTP respuestaHTTP = new RespuestaHTTP();
        Scanner lectura = new Scanner(System.in);
        try {
            String opcionSalida = "";
            while (!opcionSalida.equalsIgnoreCase("Salir")) {
                System.out.println("Escriba el codigo de la moneda base que quiere convertir:");
                var codigoMonedaBase = lectura.nextLine();
                HttpRequest solicitud = solicitudClienteHTTP.construirPeticion(codigoMonedaBase);
                System.out.println(solicitud);
                HttpResponse<String> respuesta = solicitudClienteHTTP.enviarPeticion(solicitud);
                ConversionMoneda conversion = respuestaHTTP.procesarRespuesta(respuesta);
                //ConversionEspesifica conversionEspesifica = new ConversionEspesifica();
                ConversionEspecificaDos conversionEspesificaDos = new ConversionEspecificaDos();
                System.out.println("Monedas de cambio disponibles para la conversion: "
                        + conversion.conversion_rates().keySet());
                System.out.println("Escriba el codigo de la moneda a la que quiere convertir:");
                var codigoMonedaConvertir = lectura.nextLine();
                System.out.println("Indique el valor a convertir: ");
                Double valorAConvertir = lectura.nextDouble();
                lectura.nextLine(); // Consumir el carácter de nueva línea sobrante
                //conversionEspesifica.conValorYMoneda(codigoMonedaBase.toUpperCase(), codigoMonedaConvertir.toUpperCase(), valorAConvertir, conversion);
                conversionEspesificaDos.conValorYMoneda(codigoMonedaBase.toUpperCase(), codigoMonedaConvertir.toUpperCase(), valorAConvertir, respuesta.body());
                GeneradorDeArchivo generador = new GeneradorDeArchivo();
                generador.guardarJson(conversion);
                System.out.println("Si desea continuar en el conversor de monedas " +
                        "presione enter de lo contrario ingrese salir: ");
                opcionSalida = lectura.nextLine();
            }
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizo la aplicación.");
        }
    }
}
