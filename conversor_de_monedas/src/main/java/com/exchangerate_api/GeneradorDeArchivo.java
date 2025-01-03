package com.exchangerate_api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorDeArchivo {
    public void guardarJson(ConversionMoneda conversionMoneda) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("SalidaConversiones/" + conversionMoneda.base_code() + ".json");
        escritura.write(gson.toJson(conversionMoneda));
        escritura.close();
    }
}
