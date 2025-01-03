package com.exchangerate_api;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Bienvenido a su conversor de monedas Online!!!");
        SolicitudClienteHTTP solicitudClienteHTTP = new SolicitudClienteHTTP();
        RespuestaHTTP respuestaHTTP = new RespuestaHTTP();
        Scanner lectura = new Scanner(System.in);
        HttpResponse<String> respuesta = null;
        try {
            String opcionSalida = "";
            while (!opcionSalida.equalsIgnoreCase("Salir")) {
                ConversionMoneda conversion = null;
                String codigoMonedaBase = "";

                // Solicitar hasta obtener un código de moneda válido
                while (conversion == null) {
                    try {
                        System.out.println("Escriba el código de la moneda base que quiere convertir:");
                        codigoMonedaBase = lectura.nextLine();
                        HttpRequest solicitud = solicitudClienteHTTP.construirPeticion(codigoMonedaBase);
                        respuesta = solicitudClienteHTTP.enviarPeticion(solicitud);

                        if (respuesta == null || String.valueOf(respuesta.statusCode()).startsWith("4")) {
                            throw new IllegalArgumentException("Código de moneda inválido o no disponible.");
                        }
                        conversion = respuestaHTTP.procesarRespuesta(respuesta);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Por favor, intente de nuevo.");
                    } catch (RuntimeException e) {
                        System.out.println("Error inesperado: " + e.getMessage());
                    }
                }

                //ConversionEspesifica conversionEspesifica = new ConversionEspesifica();
                //conversionEspesifica.conValorYMoneda(codigoMonedaBase.toUpperCase(), codigoMonedaConvertir.toUpperCase(), valorAConvertir, conversion);
                System.out.println("Monedas de cambio disponibles para la conversión: "
                        + conversion.conversion_rates().keySet());
                String codigoMonedaConvertir;
                while (true) {
                    System.out.println("Escriba el código de la moneda a la que quiere convertir:");
                    codigoMonedaConvertir = lectura.nextLine();

                    // Verificar si el código ingresado está en la lista de monedas disponibles
                    if (conversion.conversion_rates().containsKey(codigoMonedaConvertir.toUpperCase())) {
                        break; // Salir del bucle si el código es válido
                    } else {
                        System.out.println("El código ingresado no es válido. Ingrese un valor" +
                                "valido de la lista suminsitrada.");
                    }
                }

                System.out.println("Indique el valor a convertir: ");
                Double valorAConvertir = lectura.nextDouble();
                lectura.nextLine(); // Consumir el carácter de nueva línea sobrante

                ConversionEspecificaDos conversionEspecificaDos = new ConversionEspecificaDos();
                conversionEspecificaDos.conValorYMoneda(codigoMonedaBase.toUpperCase(), codigoMonedaConvertir.toUpperCase(), valorAConvertir, respuesta.body());

                GeneradorDeArchivo generador = new GeneradorDeArchivo();
                generador.guardarJson(conversion);
                System.out.println("Si desea continuar en el conversor de monedas " +
                        "presione enter, de lo contrario ingrese 'Salir': ");
                opcionSalida = lectura.nextLine();
            }
        } catch (RuntimeException e) {
            System.out.println("Error inesperado: " + e.getMessage());
            System.out.println("Finalizó la aplicación.");
        }
    }
}