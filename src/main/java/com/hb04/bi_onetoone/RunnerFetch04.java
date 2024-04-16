package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;


public class RunnerFetch04 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

/*        Student04 student = session.get(Student04.class, 1001);
        Diary04 diary = session.get(Diary04.class, 101);

        System.out.println(student);
        System.out.println("*******************************************************");
        System.out.println(student.getDiary());//Diary nesnesi yok Stackoverflow hatasi almamak icin kaldirdik
        System.out.println("*******************************************************");
        System.out.println(diary);
        System.out.println("*******************************************************");
        System.out.println(diary.getStudent());
        System.out.println("*******************************************************");*/

//        // Task = Diary si olan Ogrencilerin isimlerini ve gunluklerinin isimlerini getirelim :
//        String hqlQuery = "SELECT s.name,d.name FROM Student04 s INNER JOIN FETCH Diary04 d ON s.id=d.student";
//        //Native SQL---> "SELECT s.std_name,d.name FROM Student04 s INNER JOIN Diary04 d ON s.id=d.std_id";
//        List<Object[]> resultList1 = session.createQuery(hqlQuery).getResultList();
//        for (Object[] objects : resultList1) {
//            System.out.println(Arrays.toString(objects));
//        }
//        resultList1.forEach(t -> System.out.println(Arrays.toString(t)));


        //!!! TASK : bütün öğrenciler ve varsa bu ogrencilerin kitaplarini da getirelim

        String hqlQuery2 = "Select s.name,d.name from Student04 s left join fetch Diary04 d on s.id=d.student";

        List<Object[]> resultList = session.createQuery(hqlQuery2).getResultList();
        resultList.forEach(t-> System.out.println(Arrays.toString(t)));


        tx.commit();
        session.close();
        sf.close();
    }
}
