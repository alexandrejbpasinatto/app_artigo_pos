/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexandre.ongamebicho.conexao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Alexandre
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("persistence.xml").build();
            Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            sessionFactory = metaData.getSessionFactoryBuilder().build();
        } catch (Throwable th) {
            System.err.println("Enitial SessionFactory creation failed" + th);
            throw new ExceptionInInitializerError(th);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void save(Object object) {
        try {
            SessionFactory sessFact = HibernateUtil.getSessionFactory();
            Session session = sessFact.getCurrentSession();
            Transaction transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
            sessFact.close();
        } catch (Exception e) {
            Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, e.getCause());
        }
    }
    
}
