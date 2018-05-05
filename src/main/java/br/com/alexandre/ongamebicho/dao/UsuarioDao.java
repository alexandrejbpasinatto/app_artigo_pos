/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.dao;

import br.com.alexandre.ongamebicho.conexao.Conexao;
import br.com.alexandre.ongamebicho.conexao.scripts.SqlHelper;
import br.com.alexandre.ongamebicho.model.Usuario;
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
public class UsuarioDao {

    private Connection con;
    private Conexao conexao;

    public UsuarioDao() {
        conexao = new Conexao();
    }

    public void insertUsuario(Usuario usuario) throws SQLException {
        try {
            conexao.efetuaConexaoBD();
            PreparedStatement psi = conexao.con.prepareStatement(SqlHelper.insertUsuario);
            psi.setLong(1, getId());
            psi.setString(2, usuario.getLogin());
            psi.setString(3, usuario.getSenha());
            psi.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir usuario" + e.getMessage());
        } finally {
            conexao.fecharLigacao();
        }
    }

    public void updateUsuario(Usuario usuario) throws SQLException {
        try {
            conexao.efetuaConexaoBD();
            PreparedStatement psi = conexao.con.prepareStatement(SqlHelper.updateUsuario);
            psi.setLong(1, usuario.getID());
            psi.setString(2, usuario.getLogin());
            psi.setString(3, usuario.getSenha());
            psi.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar usuario: " + e.getMessage());
        } finally {
            conexao.fecharLigacao();
        }
    }

    public List<Usuario> findAll() throws SQLException {
        try {
            try {
                PreparedStatement ps = conexao.con.prepareStatement(SqlHelper.buscaUsuario);
                ResultSet rs = ps.executeQuery();
                List<Usuario> usuarios = new ArrayList<Usuario>();
                while (rs.next()) {
                    Usuario usu = new Usuario(
                            rs.getLong("ID"),
                            rs.getString("USU_LOGIN"),
                            rs.getString("USU_SENHA"));
                    usuarios.add(usu);
                }
                return usuarios;
            } catch (SQLException ex) {
                conexao.fecharLigacao();
                throw new RuntimeException("Erro ao buscar usuario !!!", ex);
            }
        } finally {
            conexao.fecharLigacao();
        }
    }

    public Long getId() {
        try {
            Statement s = conexao.con.createStatement();
            ResultSet rs = s.executeQuery(SqlHelper.selectMaxIdUsuario);
            rs.next();
            return rs.getLong("id");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar id ", ex);
        }
    }

    public void delete(Usuario usuario) throws SQLException {
        try {
            conexao.efetuaConexaoBD();
            PreparedStatement psi = conexao.con.prepareStatement(SqlHelper.deleteUsuario);
            psi.setLong(1, usuario.getID());
            psi.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar usuario: " + e.getMessage());
        } finally {
            conexao.fecharLigacao();
        }
    }

    public Usuario verificaLoginESenha(Usuario usuario) throws SQLException {
        try {
            conexao.efetuaConexaoBD();
            PreparedStatement psi = conexao.con.prepareStatement(SqlHelper.verificaLogin);
            psi.setLong(1, getId());
            psi.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar usuario" + e.getMessage());
        } finally {
            conexao.fecharLigacao();
        }
        return usuario;
    }

    public boolean getUsuario(String login, String senha) throws SQLException {
        try {
            try {
                PreparedStatement ps = conexao.con.prepareStatement(SqlHelper.verificaLogin);
                ps.setString(1, login);
                ps.setString(2, senha);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Usuario usu = new Usuario(
                            rs.getString("USU_LOGIN"),
                            rs.getString("USU_SENHA"));
                    return (usu.getLogin().equals(login)) && usu.getSenha().equals(senha);
                }

            } catch (SQLException ex) {
                conexao.fecharLigacao();
                throw new RuntimeException("Erro ao buscar usuario !!!", ex);
            }
        } finally {
            conexao.fecharLigacao();
        }
        return false;
    }
}
