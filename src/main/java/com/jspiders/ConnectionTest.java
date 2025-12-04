package com.jspiders;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionTest {
    public static void main(String[] args) {
        System.out.println("Program starts");

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.close();
        sessionFactory.close();

        System.out.println("Program ends");
    }
}
