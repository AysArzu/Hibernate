package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {
        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        Student07 student = session.get(Student07.class,1001);//bunu bile atsak query atar!
//        student.getBookList().forEach(System.out::println);

//        String hqlQuery = "Select s.name,b.name FROM Student07 s INNER JOIN FETCH Book07 b ON s.id = b.student.id";
//        List<Object[]> resultList1 = session.createQuery(hqlQuery).getResultList();
//        resultList1.forEach(t-> System.out.println(Arrays.toString(t)));

        /*  ///Delete islemi HQL*/
//        String hqlQuery2="DELETE From Book07"; //child konumunda
//        int numOfRec =session.createQuery(hqlQuery2).executeUpdate();
//        System.out.println("Effected Row Count : "+numOfRec);

//        String hqlQuery3="DELETE From Student07";//parent konumunda ilk bu calisamaz!!!! once book07 silinmeli
//        int numOfRec2 =session.createQuery(hqlQuery3).executeUpdate();
//        System.out.println("Effected Row Count : "+numOfRec2);//3


//        String hqlQuery4="DELETE FROM Student07 s WHERE s.id=1001";
//        int numOfRec3 = session.createQuery(hqlQuery4).executeUpdate();
//        System.out.println("Effected Row Count : "+numOfRec3);
        //Not : Kitabı olan öğrenciyi silmeye çalışırsam hata alacağım,
        // bunu çözmek için :
        // 1.YOL: Öğrenciye ait bütün kitapları silip sonra öğrenciyi silebiliriz.
        // 2.YOL: Student entity clasına orphanRemoval veya cascade eklenmeli

//        Student07 student2 = session.get(Student07.class,1001);
//        session.delete(student2);

        Student07 student03 = session.get(Student07.class, 1002);
        student03.getBookList().set(0,null);//orphanRemoval null olunca listeden siler
        tx.commit();
        session.close();
        sf.close();
    }
}
