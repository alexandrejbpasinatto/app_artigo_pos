/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Alexandre
 */

@Entity
public class Pessoa implements Serializable {
    
    @Id
    @GeneratedValue
    private Long codigo;
    private String nome;
    private Long cpf;
    private Integer rg;
    private Byte foto;
    private String telefone;
    private enum membro{SIM, NAO};
    private Usuario usuario;
}
