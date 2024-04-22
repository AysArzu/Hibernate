package com.hb12.get_load;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave12 {
    public static void main(String[] args) {

        Student12 student1= new Student12();
        student1.setName("Ebubekir Bey");
        student1.setMathGrade(90);

        Student12 student2= new Student12();
        student2.setName("Fatih Bey");
        student2.setMathGrade(90);

        Configuration con = new Configuration().configure().addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
                Session session = sf.openSession();
                Transaction tx =session.beginTransaction();

                session.save(student1);
                session.save(student2);



                tx.commit();
                session.close();
                sf.close();
    }
}
