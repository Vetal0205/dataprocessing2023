package Hibernate;

import Entities.Manpads;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.Managed;
import org.hibernate.service.ServiceRegistry;

import javax.swing.text.html.parser.Entity;

public class JPAConnect {
    private static SessionFactory sessionFactory;
    public JPAConnect() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
                sessionFactory = new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(Manpads.class)
                        .buildMetadata()
                        .buildSessionFactory();
            } catch (Exception e) {
                System.err.println("Error creating SessionFactory: " + e.getMessage());
                throw new ExceptionInInitializerError(e);
            }
        }
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void closeSession() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}