/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.view;

import br.com.alexandre.ongamebicho.business.AnimalBC;
import br.com.alexandre.ongamebicho.dao.AnimalDao;
import br.com.alexandre.ongamebicho.model.Animal;
import br.com.alexandre.ongamebicho.model.FotoAnimal;
import br.com.alexandre.ongamebicho.view.util.AddMessage;
import br.com.alexandre.ongamebicho.view.util.JsfUtil;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.imageio.ImageIO;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Alexandre
 */
@ManagedBean
@RequestScoped
public class AnimalMB implements Serializable {

    Animal animal = new Animal();
    AnimalDao animalDao = new AnimalDao();
    List<Animal> animais = new ArrayList<Animal>();
    FotoAnimal foto = new FotoAnimal();
    StreamedContent imagem = new DefaultStreamedContent();
    List<FotoAnimal> fotos = new ArrayList<FotoAnimal>();
    AnimalBC animalBC = new AnimalBC();

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

    public void salveOrUpdate() throws SQLException {
        if (animal.getId() == null) {
            salvar();
        } else {
            atualizar();
        }
    }

    private void salvar() {
        try {
            animalBC.valida(animal);
            AddMessage.msgInfo("animal inserido com sucesso");
        } catch (RuntimeException ex) {
            AddMessage.msgError("Ocorreu um erro ao inserir o animal " + ex.getMessage());
        } catch (SQLException ex) {
            AddMessage.msgFatal("Error: " + ex.getMessage());
        }
    }

    public void excluir(Animal animal) {
        try {
            animalDao.delete(animal);
            animais.remove(animal);
            AddMessage.msgInfo("Animal removido com sucesso");
        } catch (SQLException ex) {
            AddMessage.msgError(ex.getMessage());
        }
    }

    private void atualizar() {
        try {
            animalDao.update(animal);
            AddMessage.msgInfo("Animal atualizado com sucesso");
        } catch (SQLException e) {
            AddMessage.msgError("Ocooreu um erro ao atualizar" + e.getMessage());
        }

    }

    public void redireciona() {
        try {
            getAnimal();
            JsfUtil.redireciona("animais_form.xhtml");
        } catch (Exception ex) {
            Logger.getLogger(UsuarioMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
