package com.hb01.anotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

    public static void main(String[] args) {
        Student01 student1 = new Student01();

        student1.setId(1001);
        student1.setName("Ayşe");
        student1.setSurname("Hanim");
        student1.setGrade(99);


        Student01 student2 = new Student01();
        student2.setId(1002);
        student2.setName("Ahmet");
        student2.setSurname("Bey");
        student2.setGrade(90);

        Student01 student3 = new Student01();
        student3.setId(1003);
        student3.setName("Ebubekir");
        student3.setSurname("Bey");
        student3.setGrade(90);


        //!!! aşağıdaki satırda config dosyamı ve entity clasımı belirtiyorum.
        Configuration con = new Configuration().
                configure("hibernate.cfg.xml").
                addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        //INSERT INTO t_student01 (id, student_name, grade) VALUES(?,?,?);

        tx.commit(); //!!! commit önemli, yazılmazsa DB ye kaydedilme garantisi yok...
        session.clear();
        sf.close();


    }
}