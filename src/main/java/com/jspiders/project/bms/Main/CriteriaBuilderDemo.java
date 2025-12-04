package com.jspiders.project.bms.Main;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaPredicate;

import java.util.List;
import java.util.Scanner;

public class CriteriaBuilderDemo {
    private static SessionFactory sessionFactory;
    public static void login()
    {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = config.buildSessionFactory();
        System.out.println("sessionFactory created..");

        Session session = sessionFactory.openSession();
        System.out.println("session created..");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter mobile number to search: ");
        String mobile = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();

        HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Users> criteriaQuery = criteriaBuilder.createQuery(Users.class);

        Root<Users> table = criteriaQuery.from(Users.class);

        JpaPredicate condition1 = criteriaBuilder.equal(table.get("mobile"), "1234567890");
        JpaPredicate condition2 = criteriaBuilder.equal(table.get("password"),"abc123");

        criteriaQuery.select(table).where(condition1,condition2);

        Query<Users> query = session.createQuery(criteriaQuery);
        List<Users> resultList = query.getResultList();





        session.close();
        System.out.println("session closed successfully");
    }
}
