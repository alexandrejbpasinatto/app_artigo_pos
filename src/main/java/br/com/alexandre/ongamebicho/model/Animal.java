/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.model;

import br.com.alexandre.ongamebicho.model.Animal.animalDiponivelParaAdocao;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author Alexandre
 */

@Entity
public class Animal implements Serializable {

    @Id
    @GeneratedValue
    private Long Id;
    private String nome;
    private String raca;
    private String tipodoAnimal;
    private String descricao;
    private byte[] foto;
    private animalDiponivelParaAdocao paraAdocao;
    
    private List<FotoAnimal> fotoAnimal = new ArrayList<FotoAnimal>();
    
    @Transient
    private Pessoa pessoa;

    public Animal(Long Id, String nome, String tipodoAnimal, String descricao) {
        this.Id = Id;
        this.nome = nome;
        this.tipodoAnimal = tipodoAnimal;
        this.descricao = descricao;
    }
    
    public enum animalDiponivelParaAdocao {
        ADOTADO, DISPONIVEL, LARTEMPORARIO
    };

    public Animal() {
    }

    public Animal(Long Id, String nome, String raca, String tipodoAnimal, String descricao, byte[] foto) {
        this.Id = Id;
        this.nome = nome;
        this.raca = raca;
        this.tipodoAnimal = tipodoAnimal;
        this.descricao = descricao;
        this.foto = foto;
    }

    public animalDiponivelParaAdocao getParaAdocao() {
        return paraAdocao;
    }

    public void setParaAdocao(animalDiponivelParaAdocao paraAdocao) {
        this.paraAdocao = paraAdocao;
    }



    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getTipodoAnimal() {
        return tipodoAnimal;
    }

    public void setTipodoAnimal(String tipodoAnimal) {
        this.tipodoAnimal = tipodoAnimal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("C:/imagens/" + foto);
        fos.write(foto);
        FileDescriptor fd = fos.getFD();
        fos.flush();
        fd.sync();
        fos.close();
        String img = new String(foto);
        return img;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    private Pessoa comQuemEstaOAnimal() {
        return pessoa;
    }

    public List<FotoAnimal> getFotoAnimal() {
        return fotoAnimal;
    }

    public void setFotoAnimal(List<FotoAnimal> fotoAnimal) {
        this.fotoAnimal = fotoAnimal;
    }

    @Override
    public String toString() {
        return Arrays.toString(foto);
    }
    
    

}
