/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.model;

import java.io.Serializable;

/**
 *
 * @author Alexandre
 */
public class Usuario implements Serializable{
    
     private Long ID;
     private String login;
     private String senha;

    public Usuario() {
    }

    public Usuario(Long ID, String login, String senha) {
        this.ID = ID;
        this.login = login;
        this.senha = senha;
    }
     public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID=" + ID + ", login=" + login + ", senha=" + senha + '}';
    }
    
}
