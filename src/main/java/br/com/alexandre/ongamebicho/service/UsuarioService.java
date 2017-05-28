/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.service;

import br.com.alexandre.ongamebicho.model.Usuario;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Alexandre
 */

@Path("/usuario")
public interface UsuarioService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getAll();
}
