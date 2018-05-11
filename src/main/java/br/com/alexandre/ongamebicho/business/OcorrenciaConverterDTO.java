/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.business;

import br.com.alexandre.apiong.dto.OcorrenciaDTO;
import br.com.alexandre.ongamebicho.model.Ocorrencia;

/**
 *
 * @author Alexandre
 */
public class OcorrenciaConverterDTO {



    public OcorrenciaConverterDTO() {
    }

    public static Ocorrencia converter(OcorrenciaDTO dto) {
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setEspecie(dto.getEspecie());
        ocorrencia.setRaca(dto.getRaca());
        ocorrencia.setObservacao(dto.getObservacao());
        ocorrencia.setPosicao(dto.getPosicao());
        return ocorrencia;
    }

}
