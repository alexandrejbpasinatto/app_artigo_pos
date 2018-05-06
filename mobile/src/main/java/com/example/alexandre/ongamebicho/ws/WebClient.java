package com.example.alexandre.ongamebicho.ws;

import android.os.StrictMode;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class WebClient implements Service {



    public String get() throws IOException {

        URL url = new URL("URL Get");

        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        connection.setRequestProperty("Accept", "application/json");

        connection.connect();

        String jsonDeResposta =
                new Scanner(connection.getInputStream()).next();

        return jsonDeResposta;
    }

    @Override
    public String enviaParaServidor(List json) throws IOException {


        URL url = new URL("http:127.0.0.1:28526/OngAmeBicho/rest/ocorrencia");

        HttpURLConnection connection =
                (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");

        connection.setRequestProperty("Content-type", "application/json");
        connection.setRequestProperty("Accept", "application/json");

        connection.setDoOutput(true);

        PrintStream printStream =
                new PrintStream(connection.getOutputStream());
        printStream.println(json);

        connection.connect();

        String jsonDeResposta =
                new Scanner(connection.getInputStream()).next();

        return jsonDeResposta;
    }
}
