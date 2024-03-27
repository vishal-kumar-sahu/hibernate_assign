package org.example;

import org.example.configurations.HibernateUtils;
import org.example.entity.Aadhar;
import org.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        Person p1 = new Person();
        p1.setFname("Vishal Kumar");
        p1.setLname("Sahu");
        p1.setEmail("vishalkumar.sahu04@gmail.com");

        Aadhar a1 = new Aadhar();
        a1.setAadharNumber("340852613261");

        a1.setPerson(p1);
        p1.setPersonAadharDetails(a1);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(p1);

        session.getTransaction().commit();

        System.out.println("Printing from person -: ");
        Person savedPerson = session.get(Person.class, 1);
        System.out.println(savedPerson);

        System.out.println("Printing from aadhar -: ");
        Aadhar savedAadhar = session.get(Aadhar.class, 1);
        System.out.println(savedAadhar);

        session.close();
    }
}
