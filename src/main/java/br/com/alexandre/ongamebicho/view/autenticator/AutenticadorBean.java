/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package br.com.alexandre.ongamebicho.view.autenticator;

import br.com.alexandre.ongamebicho.dao.UsuarioDao;
import br.com.alexandre.ongamebicho.model.Usuario;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Alexandre


@RequestScoped
@ManagedBean
public class AutenticadorBean {

    UsuarioDao usuarioDao = new UsuarioDao();
    Usuario usuario = new Usuario();

    public String autentica() throws SQLException {


        Usuario usuarioLogado = usuarioDao.getUsuario(usuario.getLogin(), usuario.getSenha());
        
        Object b = new Object();

        SessionUtil.setParam("USUARIOLogado", b);

        if (usuarioLogado.getLogin().equals(usuario.getLogin()) && usuarioLogado.getSenha().equals(usuario.getSenha())) {
            return "/index.xhtml?faces-redirect=true";
        } else {
            return "/login.xhtml?faces-redirect=true";
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }
    
}
 */