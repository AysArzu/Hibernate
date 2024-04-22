package com.hb11.caching;

import com.hb10.idgeneration.Student10;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave11 {
    public static void main(String[] args) {

        Student11 student1= new Student11();
        student1.setName("Ayse Hanim");
        student1.setMathGrade(95);

        Student11 student2= new Student11();
        student2.setName("Ebrar Hanim");
        student2.setMathGrade(100);

        Student11 student3= new Student11();
        student3.setName("Ebubekir Bey");
        student3.setMathGrade(95);


        Configuration con = new Configuration().configure().addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);


        tx.commit();
        session.close();
        sf.close();
    }
}
