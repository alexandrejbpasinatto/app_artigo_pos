/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.dao;

import br.com.alexandre.ongamebicho.conexao.Conexao;
import br.com.alexandre.ongamebicho.conexao.HibernateUtil;
import br.com.alexandre.ongamebicho.conexao.scripts.SqlHelper;
import br.com.alexandre.ongamebicho.model.Animal;
import br.com.alexandre.ongamebicho.model.Ocorrencia;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Alexandre
 */
public class AnimalDao {

    private Connection con;
    private Conexao conexao;

    public AnimalDao() {
        conexao = new Conexao();
    }

    public void salvar(Animal animal) {
        HibernateUtil.save(animal);
    }

    public List<Animal> buscaTodosAnimais() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Animal> animais = session.createQuery("from Animal").list();
        session.close();

        return animais;
    }

    public List<Animal> buscaAnimais() throws SQLException {
        try {
            try {
                PreparedStatement ps = conexao.con.prepareStatement(SqlHelper.buscaAniamis);
                ResultSet rs = ps.executeQuery();
                List<Animal> animais = new ArrayList<Animal>();
                while (rs.next()) {
                    Animal animal = new Animal(
                            rs.getLong("id"),
                            rs.getString("nome"),
                            rs.getString("raca"),
                            rs.getString("tipodoAnimal"),
                            rs.getString("descricao"),
                            rs.getBytes("foto")
                    );
                    animais.add(animal);
                }
                return animais;
            } catch (SQLException ex) {
                conexao.fecharLigacao();
                throw new RuntimeException("Erro ao buscar animal !!!", ex);
            }
        } finally {
            conexao.fecharLigacao();
        }
    }

    public void insert(Animal animal) throws SQLException {
         try {
            conexao.efetuaConexaoBD();
            PreparedStatement psi = conexao.con.prepareStatement(SqlHelper.insertAnimal);
            psi.setLong(1, getId());
            psi.setString(2, animal.getNome());
            psi.setString(3, animal.getRaca());
            psi.setString(4, animal.getTipodoAnimal());
            psi.setString(5, animal.getDescricao());
            psi.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir animal" + e.getMessage());
        } finally {
            conexao.fecharLigacao();
        }
    }
    
     public void update(Animal animal) throws SQLException {
         try {
            conexao.efetuaConexaoBD();
            PreparedStatement psi = conexao.con.prepareStatement(SqlHelper.updateAnimal);
            psi.setLong(1, animal.getId());
            psi.setString(2, animal.getNome());
            psi.setString(3, animal.getRaca());
            psi.setString(4, animal.getTipodoAnimal());
            psi.setString(5, animal.getDescricao());
            psi.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar animal" + e.getMessage());
        } finally {
            conexao.fecharLigacao();
        }
    }

    public Long getId() {
        try {
            Statement s = conexao.con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(ID)+1 as id FROM animal");
            rs.next();
            return rs.getLong("id");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar id ", ex);
        }
    }

    public void delete(Animal animal) throws SQLException {
        try {
            conexao.efetuaConexaoBD();
            PreparedStatement psi = conexao.con.prepareStatement("DELETE FROM animal WHERE id = ?");
            psi.setLong(1, animal.getId());
            psi.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar animal: " + e.getMessage());
        } finally {
            conexao.fecharLigacao();
        }
    }

}
