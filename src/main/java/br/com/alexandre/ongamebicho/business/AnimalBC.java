/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.business;

import br.com.alexandre.ongamebicho.dao.AnimalDao;
import br.com.alexandre.ongamebicho.dao.UsuarioDao;
import br.com.alexandre.ongamebicho.model.Animal;

/**
 *
 * @author Alexandre
 */
public class AnimalBC {
    
    private AnimalDao animalDao = new AnimalDao();
    public void valida(Animal animal){
        animalDao.salvar(animal);
    }
    
}
