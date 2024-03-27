package org.example;

import org.example.configurations.HibernateUtils;
import org.example.entity.Student;
import org.example.entity.Mentor;
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

        Student stu1 = new Student();
        stu1.setfName("Vishal Kumar");
        stu1.setlName("Sahu");
        stu1.setEmail("vishalkumar.sahu04@gmail.com");

        Student stu2 = new Student();
        stu2.setfName("Anmol");
        stu2.setlName("Srivastava");
        stu2.setEmail("anmol.srivastava@accolitedigital.com");

        List<Student> student = new ArrayList<>();
        student.add(stu1);
        student.add(stu2);

        Mentor m1 = new Mentor();
        m1.setfName("Rupal");
        m1.setlName("Tomar");
        m1.setEmail("rupal.tomar@accolitedigital.com");

        Mentor m2 = new Mentor();
        m2.setfName("Manoj Kumar");
        m2.setlName("Arora");
        m2.setEmail("manoj.arora@accolitedigital.com");

        List<Mentor> mentor = new ArrayList<>();
        mentor.add(m1);
        mentor.add(m2);

        stu1.setMentor(mentor);
        stu2.setMentor(mentor);

        m1.setStudent(student);
        m2.setStudent(student);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(stu1);
        session.persist(stu2);
        session.persist(m1);
        session.persist(m2);

        session.getTransaction().commit();

        System.out.println("Printing from Student -: ");
        Student savedStudent1 = session.get(Student.class, 1L);
        System.out.println(savedStudent1);

        Student savedStudent2 = session.get(Student.class, 2L);
        System.out.println(savedStudent2);

        System.out.println("Printing from Mentor -: ");
        Mentor savedMentor1 = session.get(Mentor.class, 1L);
        System.out.println(savedMentor1);

        Mentor savedMentor2 = session.get(Mentor.class, 2L);
        System.out.println(savedMentor2);

        session.close();
    }
}
