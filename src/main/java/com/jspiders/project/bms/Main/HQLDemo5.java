package com.jspiders.project.bms.Main;

import com.jspiders.project.bms.Movie;
import com.jspiders.project.bms.MovieStatus;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaPredicate;

import java.util.List;

public class HQLDemo5 {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("sessionFactory created..");

        Session session = sessionFactory.openSession();
        System.out.println("session created..");

        //get the criteriaBuilder
        HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        //create dynamic query using criteriaBuilder with entity class
        CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);

        //defines the table name
        Root<Movie> table = criteriaQuery.from(Movie.class);

        //define the conditions/criteria/predicates
        JpaPredicate condition1 = criteriaBuilder.equal(table.get("status"), MovieStatus.AVAILABLE);
        JpaPredicate condition2 = criteriaBuilder.equal(table.get("title"),"Movie-1");

        //build the query using table and conditions
        criteriaQuery.select(table).where(condition1,condition2);

        Query<Movie> query = session.createQuery(criteriaQuery);
        List<Movie> resultList = query.getResultList();

        for(Movie movie : resultList){
            System.out.println(movie);
        }

        session.close();
        System.out.println("session closed..");

        sessionFactory.close();
        System.out.println("sessionFactory closed..");
    }
}
