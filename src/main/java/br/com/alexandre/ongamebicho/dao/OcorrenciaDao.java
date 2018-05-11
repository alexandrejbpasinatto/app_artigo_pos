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
import java.util.ArrayList;
import java.util.List;

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

    public List<Ocorrencia> findAll() throws SQLException {
        try {
            try {
                PreparedStatement ps = conexao.con.prepareStatement(SqlHelper.buscaOcorrencia);
                ResultSet rs = ps.executeQuery();
                List<Ocorrencia> Ocorrencias = new ArrayList<Ocorrencia>();
                while (rs.next()) {
                    Ocorrencia oco = new Ocorrencia(
                            rs.getLong("id"),
                            rs.getString("OCO_RACA"),
                            rs.getString("OCO_ESPECIE"),
                            rs.getString("OCO_OBSERVACAO"));
                    Ocorrencias.add(oco);
                }
                return Ocorrencias;
            } catch (SQLException ex) {
                conexao.fecharLigacao();
                throw new RuntimeException("Erro ao buscar ocorrencias !!!", ex);
            }
        } finally {
            conexao.fecharLigacao();
        }

    }

   public void delete(Ocorrencia ocorrencia) throws SQLException {
        try {
            conexao.efetuaConexaoBD();
            PreparedStatement psi = conexao.con.prepareStatement(SqlHelper.deleteOcorrencia);
            psi.setLong(1, ocorrencia.getId());
            psi.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar ocorrencia: " + e.getMessage());
        } finally {
            conexao.fecharLigacao();
        }
    }
}
