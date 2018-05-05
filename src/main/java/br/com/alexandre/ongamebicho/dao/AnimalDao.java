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
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

}
