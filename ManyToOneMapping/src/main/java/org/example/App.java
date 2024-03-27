package org.example;

import org.example.configurations.HibernateUtils;
import org.example.entity.Address;
import org.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

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

        List<Address> list = new ArrayList<>();

        Address add1 = new Address();
        add1.setHouseNumber("192");
        add1.setLocality("Sector 55");
        add1.setCity("Gurugram");
        add1.setState("Haryana");
        add1.setPinCode("121010");
        list.add(add1);

        Address add2 = new Address();
        add2.setHouseNumber("960");
        add2.setLocality("Kudasan");
        add2.setCity("Gandhinagar");
        add2.setState("Gujarat");
        add2.setPinCode("222010");
        list.add(add2);

        add1.setPerson(p1);
        add2.setPerson(p1);
        p1.setPersonAddress(list);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(p1);

        session.getTransaction().commit();

        System.out.println("Printing from person -: ");
        Person savedPerson = session.get(Person.class, 1L);
        System.out.println(savedPerson);

        System.out.println("Printing from Address -: ");
        Address savedAddress1 = session.get(Address.class, 1L);
        System.out.println(savedAddress1);

        Address savedAddress2 = session.get(Address.class, 2L);
        System.out.println(savedAddress2);

        session.close();
    }
}
