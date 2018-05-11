/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexandre
 */
@XmlRootElement
public class Ocorrencia implements Serializable {

    private Long id;

    private String raca;

    private String especie;

    private String Observacao;

    private byte[] Foto;

    private String posicao;

    public Ocorrencia() {
    }

    public Ocorrencia(Long id, String raca, String especie, String Observacao) {
        this.id = id;
        this.raca = raca;
        this.especie = especie;
        this.Observacao = Observacao;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] Foto) {
        this.Foto = Foto;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ocorrencia{" + "id=" + id + ", raca=" + raca + ", especie=" + especie + ", Observacao=" + Observacao + ", Foto=" + Foto + ", posicao=" + posicao + '}';
    }

}
