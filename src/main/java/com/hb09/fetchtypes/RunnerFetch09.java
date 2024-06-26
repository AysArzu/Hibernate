package com.hb09.fetchtypes;

import com.hb08.manytomany.Book08;
import com.hb08.manytomany.Student08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).
                addAnnotatedClass(Book09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

       Student09 student = session.get(Student09.class,1002);
//        System.out.println(student);

   //     Book09 book1 = session.get(Book09.class,101);



        tx.commit();
        session.close();//DB baglantisi kesildi

/*        for(Book09 book: student.getBookList()){
            System.out.println(book);
        }*/ //    @OneToMany(mappedBy="student",cascade = CascadeType.ALL/*,fetch = FetchType.EAGER*/)
            // eagerken veri geliyor yokken Exception aliyoruz

        sf.close();
    }
}
