package com.hb12.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.SortedMap;

public class RunnerFetch12 {
    public static void main(String[] args) {
        /*
   get() ---> gerçek nesneyi döndürür ,
            nesne yoksa null döner
            nesnenin olduğundan emin değilseniz get() kullanın
            dönen nesneyi hemen kullanacaksam get() kullanılmalı
   load() --> proxy nesne döndürür, gerçek nesnenin gölgesi ,
            nesne yoksa exception fırlatır
            dönen nesne üzerinde delete yapılacaksa kullanılabilir
 */
        Configuration con = new Configuration().configure().addAnnotatedClass(Student12.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

/*        System.out.println();
        System.out.println("************** Start to execute get method **************");
        Student12 student = session.get(Student12.class, 1L);
        System.out.println("************** Finish to execute get method **************");
        System.out.println("Student ID : " + student.getId());
        System.out.println("Student Name : " + student.getName());

        System.out.println("================================================");
        System.out.println("************** Start to load method **************");
        Student12 student2 = session.load(Student12.class,2L);
        System.out.println("************** Finish to load method **************");
        System.out.println("-----> call getId() ");
        System.out.println("Student2 ID : " + student2.getId());
        System.out.println("Student2 Name : " +student2.getName());*/

        //!!!db'de olmayan id'ler get load methodlarinin dacranisini gorme:
        System.out.println("************** Start to execute get method **************");
        Student12 student3 = session.get(Student12.class,5l);
        System.out.println("************** Finish to execute get method **************");

        if(student3!=null){
            System.out.println("Student ID : " + student3.getId());

        }

        System.out.println("************** Start to execute load method **************");
        Student12 student4 = session.get(Student12.class,5l);
        System.out.println("************** Finish to execute load method **************");

        if(student4!=null){
            System.out.println("Student ID : " + student4.getId());//id yazar
            System.out.println("Student name" + student4.getName());// objectNotFoundException atar

        }


        tx.commit();
        session.close();
        sf.close();
    }
}
