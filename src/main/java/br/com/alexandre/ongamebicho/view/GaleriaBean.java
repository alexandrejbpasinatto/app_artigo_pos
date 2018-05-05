/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.view;

import br.com.alexandre.ongamebicho.dao.EventoDAO;
import br.com.alexandre.ongamebicho.dao.FotoDAO;
import br.com.alexandre.ongamebicho.model.Evento;
import br.com.alexandre.ongamebicho.model.Foto;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@SessionScoped
public class GaleriaBean {

    private List<Evento> eventos = new ArrayList<Evento>();
    private Evento evento = new Evento();
    private Evento eventoSelecionado = new Evento();
    private EventoDAO eventoDAO = new EventoDAO();
    private FotoDAO fotoDAO = new FotoDAO();
    private Foto foto = new Foto();
    private StreamedContent imagem = new DefaultStreamedContent();
    private List<Foto> fotos = new ArrayList<Foto>();

    public Evento getEventoSelecionado() {
        return eventoSelecionado;
    }

    public Evento getEvento() {
        if (evento == null) {
            evento = new Evento();
        }
        return evento;
    }

    public void setEventoSelecionado(Evento eventoSelecionado) {
        this.eventoSelecionado = eventoSelecionado;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public StreamedContent getImagem() {
        return imagem;
    }

    public void setImagem(StreamedContent imagem) {
        this.imagem = imagem;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
    }

    public void salvaEvento() {
        try {
            eventoDAO.salva(evento);
            evento = new Evento();
            eventos = eventoDAO.listaTodos();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Evento adicionado", "Evento adicionado"));
        } catch (SQLException ex) {
            Logger.getLogger(GaleriaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvaFotos() {
        try {
            fotoDAO.salva(foto);
            foto = new Foto();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Foto adicionada", "Foto adicionada"));
        } catch (SQLException ex) {
            Logger.getLogger(GaleriaBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void enviaImagem(FileUploadEvent event) {
        try {
            imagem = new DefaultStreamedContent(event.getFile().getInputstream());
            foto.setEvento(eventoSelecionado);
            foto.setImagem(event.getFile().getContents());
        } catch (IOException ex) {
            Logger.getLogger(GaleriaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void criaArquivo(byte[] bytes, String arquivo) {
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(arquivo);
            fos.write(bytes);
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GaleriaBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GaleriaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listaFotosEvento() {
        try {
            fotos = fotoDAO.buscaPorEvento(eventoSelecionado);
            for (Foto f : fotos) {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();
                String nomeArquivo = f.getId().toString() + ".jpg";
                String arquivo = scontext.getRealPath("C:/imagens/" + nomeArquivo);
                criaArquivo(f.getImagem(), arquivo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GaleriaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public GaleriaBean() {
        try {
            eventos = eventoDAO.listaTodos();
        } catch (SQLException ex) {
            Logger.getLogger(GaleriaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
