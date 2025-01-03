package com.exchangerate_api;

import java.text.DecimalFormat;
import java.util.Map;

public class ConversionEspesifica {

    public void conValorYMoneda(String codigoMonedaBase, String codigoMonedaConvertir, Double valorAConvertir, ConversionMoneda conversionMoneda) {

        if (conversionMoneda != null) {
            // Iterar sobre el mapa conversion_rates
            for (Map.Entry<String, Double> entry : conversionMoneda.conversion_rates().entrySet()) {
                // Obtener la clave y el valor
                String clave = entry.getKey(); // La clave, por ejemplo, "USD"
                Double valor = entry.getValue(); // El valor, por ejemplo, 0.00022724

                // Aquí puedes hacer un tratamiento especial para ciertas claves
                if (clave.equals(codigoMonedaConvertir)) {
                    System.out.println("Tratamiento especial para USD: " + valor);
                    Double valorEspecificoConvertido = valor * valorAConvertir;

                    // Formatear con 2 decimales
                    DecimalFormat formato = new DecimalFormat("#.##");
                    String resultadoFormateado = formato.format(valorEspecificoConvertido);
                    System.out.println("La conversion de: " + valorAConvertir + " " + codigoMonedaBase +
                            " es: " + resultadoFormateado + " " + codigoMonedaConvertir);
                }
            }
        } else {
            System.out.println("El objeto ConversionMoneda es nulo.");
        }


    }
}
