package com.hb03.uni_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student03.class)
                .addAnnotatedClass(Diary03.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //!!!student fetch ediyoruz 1001 id ile
        Student03 student = session.get(Student03.class,1001);
        Diary03 diary = session.get(Diary03.class,101);

        System.out.println(student);
        System.out.println("***************************************************************");
        System.out.println(diary);
        System.out.println("***************************************************************");
        System.out.println(diary.getStudent());
        tx.commit();
        session.close();
        sf.close();
    }
}