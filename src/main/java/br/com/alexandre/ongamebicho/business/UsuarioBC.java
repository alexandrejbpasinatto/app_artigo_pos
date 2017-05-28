/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.business;

import br.com.alexandre.ongamebicho.dao.UsuarioDao;
import br.com.alexandre.ongamebicho.model.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Alexandre
 */
public class UsuarioBC {
    UsuarioDao usuarioDao = new UsuarioDao();
    
    public void valida (Usuario usuario) throws RuntimeException, SQLException {
         if ((usuario.getLogin().isEmpty())) {
            throw new RuntimeException("O usuário deve possuir um login!");
        }
        if ((usuario.getSenha().isEmpty())) {
            throw new RuntimeException("O usuário deve possuir uma senha!");
        }
        usuarioDao.insertUsuario(usuario);
    }
}
