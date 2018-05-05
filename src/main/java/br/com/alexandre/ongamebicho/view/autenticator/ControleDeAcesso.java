/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.view.autenticator;

import br.com.alexandre.ongamebicho.model.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alexandre
 */
@WebFilter(servletNames = {"Faces Servlet"})
public class ControleDeAcesso implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if ((session.getAttribute("user") != null)
                || (req.getRequestURI().endsWith("login.xhtml"))
                || (req.getRequestURI().contains("javax.faces.resource/"))) {

            //redireciona("/logado.xhtml", response);
            chain.doFilter(request, response);
        } else {
            redireciona("login.xhtml", response);
        }
    }

    @Override
    public void destroy() {
    }

    private void redireciona(String url, ServletResponse response)
            throws IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(url);
    }

}
