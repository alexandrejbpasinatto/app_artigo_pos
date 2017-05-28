/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.view;

import br.com.alexandre.ongamebicho.dao.UsuarioDao;
import br.com.alexandre.ongamebicho.model.Usuario;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Alexandre
 */

@ViewScoped
public class LoginMB {
    
private UsuarioDao usuarioDao;
private Usuario usuario;

}
