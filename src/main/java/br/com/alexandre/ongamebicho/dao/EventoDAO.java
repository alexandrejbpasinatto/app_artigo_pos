/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.dao;

import br.com.alexandre.ongamebicho.conexao.Conexao;
import br.com.alexandre.ongamebicho.model.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {

    private Connection con;
    private Conexao conexao;
    private final String COL_ID = "id";
    private final String COL_NOME = "nome";
    private final String COL_DATA = "data";

    public EventoDAO() {
        conexao = new Conexao();
    }

    public List<Evento> listaTodos() throws SQLException {
        List<Evento> eventos = new ArrayList<Evento>();
        String sql = "select * from eventos order by data";
        PreparedStatement ps = conexao.con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Evento evento = new Evento();
            evento.setId(rs.getLong(COL_ID));
            evento.setNome(rs.getString(COL_NOME));
            evento.setData(new java.util.Date(rs.getDate(COL_DATA).getTime()));
            eventos.add(evento);
        }
        return eventos;
    }

    public Evento buscaPorId(long id) throws SQLException {
        Evento evento = null;
        String sql = "select * from eventos where id=?";
        PreparedStatement ps = conexao.con.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            evento = new Evento();
            evento.setId(id);
            evento.setNome(rs.getString(COL_NOME));
            evento.setData(new java.util.Date(rs.getDate(COL_DATA).getTime()));
        }
        return evento;
    }

    public void salva(Evento evento) throws SQLException {
        String sql = "";
        if (evento.getId() != null) {
            sql = "update eventos set nome=?, data=? where id=?";
        } else {
            sql = "insert into eventos(nome,data) values(?,?)";
        }
        PreparedStatement ps = conexao.con.prepareStatement(sql);
        ps.setString(1, evento.getNome());
        ps.setDate(2, new java.sql.Date(evento.getData().getTime()));
        if (evento.getId() != null) {
            ps.setLong(3, evento.getId());
        }
        ps.execute();
    }
}
