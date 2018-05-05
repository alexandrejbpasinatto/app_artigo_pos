/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.dao;

import br.com.alexandre.ongamebicho.conexao.Conexao;
import br.com.alexandre.ongamebicho.conexao.scripts.SqlHelper;
import br.com.alexandre.ongamebicho.model.Ocorrencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alexandre
 */
public class OcorrenciaDao {
    
    private Connection con;
    private Conexao conexao;

    public OcorrenciaDao() {
         conexao = new Conexao();
    }
    
    public void save(Ocorrencia ocorrencia) throws SQLException {
         try {
            conexao.efetuaConexaoBD();
            PreparedStatement psi = conexao.con.prepareStatement(SqlHelper.insertOcorrencia);
            psi.setLong(1, getId());
            psi.setString(2, ocorrencia.getRaca());
            psi.setString(3, ocorrencia.getEspecie());
            psi.setString(4, ocorrencia.getObservacao());
            psi.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir usuario" + e.getMessage());
        } finally {
            conexao.fecharLigacao();
        }
    }
    
 public Long getId() {
        try {
            Statement s = conexao.con.createStatement();
            ResultSet rs = s.executeQuery(SqlHelper.selectMaxIdOcorrencia);
            rs.next();
            return rs.getLong("id");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar id ", ex);
        }
    }
    
}
