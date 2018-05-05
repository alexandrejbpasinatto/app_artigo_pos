/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.model;

/**
 *
 * @author Alexandre
 */
public class FotoAnimal {
    
    private Long id;
    private byte[] imagem;
    private String descricao;
    private int ordem;
    private Animal animal = new Animal();

    public FotoAnimal() {
    }

    public FotoAnimal(Long id, byte[] imagem, String descricao, int ordem) {
        this.id = id;
        this.imagem = imagem;
        this.descricao = descricao;
        this.ordem = ordem;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    
}
