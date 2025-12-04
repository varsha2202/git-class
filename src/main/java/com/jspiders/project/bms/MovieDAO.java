package com.jspiders.project.bms;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.Scanner;

public class MovieDAO {

    public static SessionFactory sessionFactory = null;
    static
    {
        //load configuration
        System.out.println("1.Load Configuration");
        Configuration config = new Configuration();
        config.configure("hibernate.bms.cfg.xml");

        //create sessionfactory
        System.out.println("2.Create SessionFactory");
        sessionFactory = config.buildSessionFactory();
    }

    MovieDAO movieDAO = new MovieDAO();

    public static void addMovie()
    { //create session
        System.out.println("3.Create Session");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //logics
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the movie title: ");
        String title = sc.nextLine();
        System.out.println("Enter the language: ");
        String language = sc.nextLine();
        System.out.println("Enter the certification: ");
        String certification = sc.nextLine();
        System.out.println("Enter the duration in minutes: ");
        Integer duration = sc.nextInt();
        System.out.println("Enter created by: ");
        Long createdBy = sc.nextLong();

        Movie movie1 = new Movie();
        movie1.setTitle(title);
        movie1.setLanguage(language);
        movie1.setCertification(certification);
        movie1.setDuration(duration);
        movie1.setStatus(MovieStatus.AVAILABLE);
        movie1.setCreatedAt(LocalDate.now());
        movie1.setCreatedBy(createdBy);

        try
        {
            System.out.println("4.Save Entity to DB");
            session.persist(movie1);//persist-->save
            transaction.commit();
            System.out.println("Save Entity to DB SUCCESS");
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
        System.out.println("5.Close Session");
        session.close();
    }

    public static void updateMovie()
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Scanner sc = new Scanner(System.in);

        System.out.println("4. Find the movie by ID");
        Movie movie = session.find(Movie.class, 2);//select * from movie where id = 1

        System.out.println("5. Update the movie data");

        System.out.println("Enter the new duration in minutes: ");
        Integer new_duration = sc.nextInt();

        movie.setDuration(new_duration);
        movie.setStatus(MovieStatus.NOT_AVAILABLE);
        movie.setUpdatedAt(LocalDate.now());
        movie.setUpdatedBy(153l);

        session.merge(movie);//update db
        transaction.commit();

        System.out.println("Update Success");

        System.out.println("6.Close Session");
        session.close();
    }

    public static void deleteMovie()
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("delete the movie by ID");
        Movie movie = session.find(Movie.class, 2);

        session.remove(movie);
        transaction.commit();

        System.out.println("Delete Success");
        session.close();
    }

}
