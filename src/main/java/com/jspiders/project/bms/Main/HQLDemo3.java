package com.jspiders.project.bms.Main;

import com.jspiders.project.bms.Movie;
import com.jspiders.project.bms.MovieStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class HQLDemo3 {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("sessionFactory created..");

        Session session = sessionFactory.openSession();
        System.out.println("session created..");

        Scanner sc = new Scanner(System.in);

        String selectUsersByName_HQL = "FROM Movie mov WHERE mov.status = :status";
        Query<Movie> query = session.createQuery(selectUsersByName_HQL,Movie.class);

        System.out.println("Enter movie status to search: ");
        String status = sc.next();
        query.setParameter("status", MovieStatus.valueOf(status));
        List<Movie> movies = query.getResultList();

        for(Movie m : movies){
            System.out.println(m);
        }

        session.close();
        System.out.println("session closed..");

        sessionFactory.close();
        System.out.println("sessionFactory closed..");

    }
}
