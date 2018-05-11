/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.business;

import br.com.alexandre.ongamebicho.dao.AnimalDao;
import br.com.alexandre.ongamebicho.dao.UsuarioDao;
import br.com.alexandre.ongamebicho.model.Animal;
import java.sql.SQLException;

/**
 *
 * @author Alexandre
 */
public class AnimalBC {

    private AnimalDao animalDao = new AnimalDao();

    public void valida(Animal animal) throws SQLException {
        if ((animal.getNome().isEmpty())) {
            throw new RuntimeException("O animal deve possuir um nome!");
        }
        if ((animal.getTipodoAnimal().isEmpty())) {
            throw new RuntimeException("informe a espécie do animal!");
        }
        animalDao.insert(animal);
    }

}
