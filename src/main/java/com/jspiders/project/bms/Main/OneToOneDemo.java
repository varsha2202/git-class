package com.jspiders.project.bms.Main;

import com.jspiders.project.bms.AudiAddress;
import com.jspiders.project.bms.Auditorium;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {
    public static void main(String[] args) {
        System.out.println("Program starts");

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.bms.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Auditorium audi = new Auditorium();
        AudiAddress audiAddress = new AudiAddress();

        audi.setAudiName("Audi-1");
        audi.setSeatRows(30);
        audi.setSeatColumns(10);

        audiAddress.setStreet("street-1");
        audiAddress.setArea("Hbr");
        audiAddress.setCity("Blr");
        audiAddress.setPincode(560833);

        audi.setAudiAddress(audiAddress);

        session.persist(audi);

        transaction.commit();
        session.close();
        sessionFactory.close();

        System.out.println("Program ends");
    }
}
