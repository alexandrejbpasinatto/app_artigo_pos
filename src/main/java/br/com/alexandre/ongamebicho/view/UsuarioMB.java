/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.view;

import br.com.alexandre.ongamebicho.business.UsuarioBC;
import br.com.alexandre.ongamebicho.dao.UsuarioDao;
import br.com.alexandre.ongamebicho.model.Usuario;
import br.com.alexandre.ongamebicho.view.util.JsfUtil;
import br.com.alexandre.ongamebicho.view.util.AddMessage;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Alexandre
 */
@ManagedBean
@RequestScoped
public class UsuarioMB implements Serializable{

    List<Usuario> usuarios = new ArrayList<>();
    Usuario usuario = new Usuario();
    UsuarioDao usuarioDao = new UsuarioDao();
    UsuarioBC usuarioBC = new UsuarioBC();

    public UsuarioMB() throws SQLException {
        this.usuarios = usuarioDao.findAll();
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void novo() {
        this.usuario = new Usuario();
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void onSelecEvent(SelectEvent event) {
        usuario = (Usuario) event.getObject();
    }

    public void salveOrUpdate() throws RuntimeException, SQLException {
        if (usuario.getID() == null) {
            salvar();
        } else {
            atualizar();
        }
    }

    public void excluir(Usuario usuario) {
        try {
            usuarioDao.delete(usuario);
            usuarios.remove(usuario);
            AddMessage.msgInfo("Usuário removido com sucesso");
        } catch (SQLException ex) {
             AddMessage.msgError(ex.getMessage());
        }
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private void salvar() {
        try {
            usuarioBC.valida(usuario);
            usuarios.add(usuario);
            AddMessage.msgInfo("Usuário Salvo Com Sucesso");
        } catch (RuntimeException ex) {
           AddMessage.msgError("Errro ao salvar Usuário: " + ex.getMessage());
        } catch (SQLException ex) {
            AddMessage.msgFatal(ex.getMessage());
        }
    }

     private void atualizar() {
        try {
            usuarioDao.updateUsuario(usuario);
            AddMessage.msgInfo("Usuário atualizado com sucesso");
        } catch (RuntimeException ex) {
            AddMessage.msgError("Ocorreu um erro ao atualizar o usuário " + ex.getMessage());
        } catch (SQLException ex) {
             AddMessage.msgFatal("Error: " + ex.getMessage());
        }
    }

    private void redireciona() {
        try {
            JsfUtil.redireciona("usuario.xhtml");
        } catch (Exception ex) {
            Logger.getLogger(UsuarioMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
