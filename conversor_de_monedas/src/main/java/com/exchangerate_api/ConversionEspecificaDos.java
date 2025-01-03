package com.exchangerate_api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversionEspecificaDos {

    public void conValorYMoneda(String codigoMonedaBase, String codigoMonedaConvertir, Double valorAConvertir, String respuestaString) {

        // Parsear la respuesta JSON
        JsonObject jsonObject = JsonParser.parseString(respuestaString).getAsJsonObject();

        // Acceder a las propiedades específicas
        String result = jsonObject.get("result").getAsString();
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

        // Obtener valores específicos del mapa conversion_rates
        double tasaDeConversion = conversionRates.get(codigoMonedaConvertir).getAsDouble();


        // Imprimir valores
        System.out.println("Resultado: " + result);
        System.out.println("Tasa de conversion: " + tasaDeConversion);


        // Tratamiento adicional con las tasas
        double conversionEspecifica = tasaDeConversion * valorAConvertir;


        System.out.println("La conversion de: " + valorAConvertir + " " + codigoMonedaBase +
                " equivale a: " + String.format("%.2f", conversionEspecifica) + codigoMonedaConvertir);
    }
}
