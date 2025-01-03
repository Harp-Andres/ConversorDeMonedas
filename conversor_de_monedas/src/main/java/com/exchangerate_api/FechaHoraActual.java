package com.exchangerate_api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FechaHoraActual {

    public static String obtener() {
        // Obtener la fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        // Formatear la fecha y hora
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        return fechaHoraActual.format(formato);
    }
}
