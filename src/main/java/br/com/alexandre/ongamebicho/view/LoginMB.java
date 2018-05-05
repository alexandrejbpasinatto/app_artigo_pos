/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.view;

import br.com.alexandre.ongamebicho.dao.UsuarioDao;
import br.com.alexandre.ongamebicho.model.Usuario;
import br.com.alexandre.ongamebicho.view.util.AddMessage;
import br.com.alexandre.ongamebicho.view.util.JsfUtil;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alexandre
 */
@ManagedBean
@ViewScoped
public class LoginMB implements Serializable {

    private UsuarioDao usuarioDao = new UsuarioDao();
    private Usuario usuario;

    public void efetuarLogin() throws Exception {

        String login = usuario.getLogin();
        String senha = usuario.getSenha();

        try {
            if (login.isEmpty()) {
                AddMessage.msgWarn("Preencha o campo Login");
            }
            if (senha.isEmpty()) {
                AddMessage.msgWarn("Preencha o campo Senha");
            } else if (usuarioDao.getUsuario(login, senha)) {
                JsfUtil.redireciona("index.xhtml");
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", usuario);
            } else {
                AddMessage.msgError("Usuário ou senha não encontrado");
            }
        } catch (SQLException ex) {
            AddMessage.msgFatal("Erro: " + ex.getMessage());
        }
    }

    public static void sair() throws Exception {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        JsfUtil.redireciona("login.xhtml");
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }
    
}
