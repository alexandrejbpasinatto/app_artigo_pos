/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.view;

import br.com.alexandre.ongamebicho.dao.AnimalDao;
import br.com.alexandre.ongamebicho.model.Animal;
import br.com.alexandre.ongamebicho.model.FotoAnimal;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Alexandre
 */
@ManagedBean
@ViewScoped
public class AnimalMB {

    Animal animal = new Animal();
    AnimalDao animalDao = new AnimalDao();
    List<Animal> animais = new ArrayList<Animal>();
    FotoAnimal foto = new FotoAnimal();
    StreamedContent imagem = new DefaultStreamedContent();
    List<FotoAnimal> fotos = new ArrayList<FotoAnimal>();

    public AnimalMB() throws SQLException {
        this.animais = animalDao.buscaAnimais();
    }

    public Animal getAnimal() {
        if (animal == null) {
            animal = new Animal();
        }
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public Image visualizaFoto(byte[] foto) throws FileNotFoundException, IOException {

        BufferedImage img = null;
        img = ImageIO.read(new ByteArrayInputStream(foto));
        ImageIO.write(img, "PNG", new File("C:/imagens/"));
        return img;
    }

    public BufferedImage verFoto(byte[] foto) throws IOException {
        BufferedImage img = null;
        img = ImageIO.read(new ByteArrayInputStream(foto));
        ImageIO.write(img, "PNG", new File("C:/imagens/"));
        return img;
    }
}
