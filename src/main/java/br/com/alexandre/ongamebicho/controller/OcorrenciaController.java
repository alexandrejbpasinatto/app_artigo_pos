/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.controller;

import br.com.alexandre.ongamebicho.dao.OcorrenciaDao;
import br.com.alexandre.ongamebicho.model.Ocorrencia;
import br.com.alexandre.ongamebicho.service.OcorrenciaService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandre
 */
public class OcorrenciaController implements OcorrenciaService{
    
    private OcorrenciaDao ocorrenciaDao = new OcorrenciaDao();
    private Ocorrencia ocorrencia = new Ocorrencia();

    @Override
    public List<Ocorrencia> getAll() {
       List<Ocorrencia> ocorrencias = new ArrayList<>();
       ocorrencia.setEspecie("teste");
       ocorrencias.add(ocorrencia);
       
       return ocorrencias;
    }

    @Override
    public void Insert(Ocorrencia ocorrencia) {
        try {
            ocorrenciaDao.save(ocorrencia);
        } catch (SQLException ex) {
            Logger.getLogger(OcorrenciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
