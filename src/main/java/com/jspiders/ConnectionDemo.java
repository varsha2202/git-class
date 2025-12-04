package com.jspiders;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionDemo {
    public static void main(String[] args) {
        System.out.println("Program Starts");

        //load configuration
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        //build session factory
        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("Session factory created");

        //get session from session factory
        Session session = sessionFactory.openSession();//connects to db
        System.out.println("Session created");

        //logics

        //close session
        session.close();
        System.out.println("Session closed");
        //close session factory
        sessionFactory.close();
        System.out.println("Session factory closed");

        System.out.println("Program Ends");
    }
}
