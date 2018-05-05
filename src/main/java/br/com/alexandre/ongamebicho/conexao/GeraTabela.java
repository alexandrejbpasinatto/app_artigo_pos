/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.conexao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alexandre
 */
public class GeraTabela {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("ong");

        factory.close();
    }
}
