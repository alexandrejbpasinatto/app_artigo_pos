/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alexandre
 */
public class Conexao {
    
     public Connection con;

    public Conexao() {
        this.efetuaConexaoBD();
    }

    public void efetuaConexaoBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //String caminhoBase = "";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ong", "root", "");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Erro ao registrar a Classe mysql !!", ex);
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao conectar a base de dados !!", ex);
        }
    }

    public void fecharLigacao() throws SQLException {
        con.close();
        con = null;
    }

    public void iniciarTransacao() throws SQLException {
        con.setAutoCommit(false);
    }

    public void finalizarTransacao() throws SQLException {
        con.commit();
    }

    public void cancelarTransacao() throws SQLException {
            con.rollback();
    }
    
}
