package com.jspiders.project.bms.Main;

import com.jspiders.project.bms.MovieDAO;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Mainclass {
    public static SessionFactory sessionFactory = null;

        public static void main(String[] args) {
            System.out.println("Program starts...");

            //MovieDAO.addMovie();
            //MovieDAO.updateMovie();
            MovieDAO.deleteMovie();

            System.out.println("6.Close Session Factory");
            sessionFactory.close();

            System.out.println("Program ends...");
        }
}







