package com.jspiders.project.bms.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLDemo {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("sessionFactory created..");

        Session session = sessionFactory.openSession();
        System.out.println("session created..");

        String selectUsersByName_HQL = "FROM Users usr WHERE usr.username = 'virat'";

        Query<Users> query = session.createQuery(selectUsersByName_HQL, Users.class);
        Users users = query.uniqueResult();
        System.out.println(users);

        session.close();
        System.out.println("session closed..");

        sessionFactory.close();
        System.out.println("sessionFactory closed..");

    }
}