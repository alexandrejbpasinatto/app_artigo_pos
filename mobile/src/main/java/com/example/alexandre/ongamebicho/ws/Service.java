package com.example.alexandre.ongamebicho.ws;

import java.io.IOException;
import java.util.List;

public interface Service {

    public String enviaParaServidor(List json) throws IOException;
}
