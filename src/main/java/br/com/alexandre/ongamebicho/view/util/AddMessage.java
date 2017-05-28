/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.view.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Alexandre
 */
public class AddMessage {

    public static void msgError(String mensagem) {

        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null));
    }

    public static void msgWarn(String mensagem) {

        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, null));
    }

    public static void msgInfo(String mensagem) {

        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null));
    }

    public static void msgFatal(String mensagem) {

        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, mensagem, null));
    }

}
