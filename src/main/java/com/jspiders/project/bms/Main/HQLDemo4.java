package com.jspiders.project.bms.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Scanner;

public class HQLDemo4 {
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

        String findByMobAndPwd_HQL = "FROM Users usr WHERE usr.mobile = :mobile AND usr.password = :password";
        Query<Users> query = session.createQuery(findByMobAndPwd_HQL, Users.class);

        query.setParameter("mobile", mobile);
        query.setParameter("password", password);

        Users users = query.uniqueResult();

        if(users!=null){
            System.out.println("Login successful..");
        }
        else{
            System.out.println("Login failed..");
        }

        session.close();
        System.out.println("session closed..");
    }

    public static void main(String[] args) {

        login();
        sessionFactory.close();
        System.out.println("sessionFactory closed..");
    }
}
