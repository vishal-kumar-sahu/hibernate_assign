package org.example;

import org.example.configurations.HibernateUtils;
import org.example.entity.Employee;
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
        System.out.println( "Hello World!" );

        Employee employee = new Employee();
        employee.setEmpName("Vishal Kumar Sahu");
        employee.setEmpEmail("vishal.sahu@accolite.com");

        Employee employee2 = new Employee();
        employee2.setEmpName("Vishal Kumar Sahu");
        employee2.setEmpEmail("202052347@iiitvadodara.ac.in");

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(employee);
        session.persist(employee2);

        session.getTransaction().commit();

        System.out.println("After saving -: ");
        session.createQuery("from Employee", Employee.class).list().forEach(System.out::println);
        session.close();

        System.out.println("Second session -: ");
        Session session2 = sessionFactory.openSession();
        session2.beginTransaction();

        //read
        Employee savedEmployee = session2.get(Employee.class, 1L);
        System.out.println(savedEmployee);

        //update
        savedEmployee.setEmpEmail("vishalkumar.sahu04@gmail.com");
        session2.merge(savedEmployee);

        session2.createQuery("from Employee", Employee.class).list().forEach(System.out::println);

        //delete
        Employee emp = session2.get(Employee.class, 2L);
        System.out.println("To be deleted : " + emp.getEmpName());
        session2.remove(emp);

        session2.getTransaction().commit();

        session2.createQuery("from Employee", Employee.class).list().forEach(System.out::println);

        session2.close();
    }
}
