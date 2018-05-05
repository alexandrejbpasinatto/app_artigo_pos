/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.service;

import br.com.alexandre.ongamebicho.model.Ocorrencia;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Alexandre
 */

@Path("/ocorrencia")
public interface OcorrenciaService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ocorrencia> getAll();
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void Insert(Ocorrencia ocorrencia);
}
