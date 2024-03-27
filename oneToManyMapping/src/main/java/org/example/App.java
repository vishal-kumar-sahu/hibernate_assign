package org.example;

import org.example.configurations.HibernateUtils;
import org.example.entity.Account;
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

        List<Account> list = new ArrayList<>();

        Account acc1 = new Account();
        acc1.setAccountNumber(3678568997L);
        acc1.setAccountType("Saving");
        acc1.setAmount(1000000.0);
        list.add(acc1);

        Account acc2 = new Account();
        acc2.setAccountNumber(367997L);
        list.add(acc2);

        acc1.setPerson(p1);
        acc2.setPerson(p1);
        p1.setPersonAccountDetails(list);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(p1);

        session.getTransaction().commit();

        System.out.println("Printing from person -: ");
        Person savedPerson = session.get(Person.class, 1L);
        System.out.println(savedPerson);

        System.out.println("Printing from Account -: ");
        Account savedAccount = session.get(Account.class, 1L);
        System.out.println(savedAccount);

        Account savedAccount2 = session.get(Account.class, 2L);
        System.out.println(savedAccount2);

        session.close();
    }
}
