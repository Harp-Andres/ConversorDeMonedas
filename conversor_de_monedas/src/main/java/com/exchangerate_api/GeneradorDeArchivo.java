package com.exchangerate_api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public void guardarJson(ConversionMoneda conversionMoneda) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = null;
        try {
            escritura = new FileWriter("SalidaConversiones/" + conversionMoneda.base_code() +
                    "_" + FechaHoraActual.obtener()  + ".json");
            escritura.write(gson.toJson(conversionMoneda));
            escritura.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
