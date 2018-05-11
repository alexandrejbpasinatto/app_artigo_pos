/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.view;

import br.com.alexandre.ongamebicho.dao.OcorrenciaDao;
import br.com.alexandre.ongamebicho.model.Ocorrencia;
import br.com.alexandre.ongamebicho.view.util.AddMessage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Alexandre
 */
@ManagedBean
@ViewScoped
public class OcorrenciaMB {

    List<Ocorrencia> ocorrencias = new ArrayList<>();
    Ocorrencia ocorrencia = new Ocorrencia();
    OcorrenciaDao ocorrenciaDao = new OcorrenciaDao();

    public OcorrenciaMB() throws SQLException {
        this.ocorrencias = ocorrenciaDao.findAll();
    }

    public Ocorrencia getOcorrencia() {
        if (ocorrencia == null) {
            ocorrencia = new Ocorrencia();
        }
        return ocorrencia;
    }

    public List<Ocorrencia> getOcorrencias() {
        return this.ocorrencias;
    }
    
   public void excluir(Ocorrencia ocorrencia) {
        try {
            ocorrenciaDao.delete(ocorrencia);
            ocorrencias.remove(ocorrencia);
            AddMessage.msgInfo("Ocorrencia removida com sucesso");
        } catch (SQLException ex) {
             AddMessage.msgError(ex.getMessage());
        }
    }
}
