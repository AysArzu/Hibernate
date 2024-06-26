package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {
    public static void main(String[] args) {

        Configuration con = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student02.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student02 student = session.get(Student02.class, 1001);
        System.out.println(student);//Student02{id=1001, name='Ayse', grade=80} adresi sildik gelmedi
        System.out.println(student.getAddress());//Address{zipcode='34000', country='Turkey', street='Apple Street', city='Istanbul'}


        tx.commit();
        session.close();
        sf.close();
    }
}
