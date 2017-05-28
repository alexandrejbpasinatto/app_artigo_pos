/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.controller;

import br.com.alexandre.ongamebicho.dao.UsuarioDao;
import br.com.alexandre.ongamebicho.model.Usuario;
import br.com.alexandre.ongamebicho.service.UsuarioService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Alexandre
 */
public class UsuarioController implements UsuarioService{
    
    private UsuarioDao usuarioDao = new UsuarioDao();

    @Override
    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            usuarios =  usuarioDao.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

}
