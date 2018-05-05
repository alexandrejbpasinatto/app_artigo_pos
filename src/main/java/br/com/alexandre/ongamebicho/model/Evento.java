/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evento {

    private Long id;
    private String nome;
    private Date data;
    private List<Foto> fotos = new ArrayList<Foto>();

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }
}
