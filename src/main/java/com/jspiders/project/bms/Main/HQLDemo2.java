package com.jspiders.project.bms.Main;

import com.jspiders.project.bms.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLDemo2 {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("sessionFactory created..");

        Session session = sessionFactory.openSession();
        System.out.println("session created..");

        String selectUsersByName_HQL = "FROM Movie mov WHERE mov.status = 'AVAILABLE'";

        Query<Movie> query = session.createQuery(selectUsersByName_HQL, Movie.class);
        List<Movie> resultList = query.getResultList();

        for (Movie mov : resultList) {
            System.out.println(mov);
        }

        session.close();
        System.out.println("session closed..");

        sessionFactory.close();
        System.out.println("sessionFactory closed..");

    }
}
