/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.controller;

import br.com.alexandre.apiong.dto.OcorrenciaDTO;
import br.com.alexandre.apiong.dto.resource.OcorrenciaService;
import br.com.alexandre.ongamebicho.business.OcorrenciaConverterDTO;
import br.com.alexandre.ongamebicho.dao.OcorrenciaDao;
import br.com.alexandre.ongamebicho.model.Ocorrencia;
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
    private OcorrenciaDTO ocorrenciaDTO = new OcorrenciaDTO();

    @Override
    public List<OcorrenciaDTO> getAll() {
       List<OcorrenciaDTO> ocorrencias = new ArrayList<>();
       ocorrenciaDTO.setEspecie("teste");
       ocorrencias.add(ocorrenciaDTO);
       
       return ocorrencias;
    }

    @Override
    public void insert(OcorrenciaDTO ocorrenciaDTO) {
        Ocorrencia ocorrencia = OcorrenciaConverterDTO.converter(ocorrenciaDTO);
        try {
            ocorrenciaDao.save(ocorrencia);
        } catch (SQLException ex) {
            Logger.getLogger(OcorrenciaController.class.getName()).log(Level.SEVERE, null, ex.getCause());
        }
    }
    
}
