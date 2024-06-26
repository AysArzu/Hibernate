package com.hb13.entity_life_cycle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
Hinernate in Objeler ile nasıl çalıştığı ile ilgili ek bilgi :

	Entity State :

		1) Transient : Objenin newlenmiş hali, DB ile ilişkisi yok. Bu durumda,
		nesne henüz bir Hibernate session'ına kaydedilmemiştir ve veritabanında bir karşılığı
		yoktur. Geçici durumdaki bir nesne, session'ın kapatılmasıyla birlikte kaybolur.

		2) Persisted or Managed : DB de row a karşılık geldiği durum, save(),get() vs. yapıldığı
		zamana denk geliyor. Bu durumda, nesne bir Hibernate session'ına kaydedilmiştir ve
		veritabanında bir karşılığı vardır. Kalıcı durumdaki bir nesne, session kapatılsa
		bile veritabanında kalır ve daha sonra yeniden kullanılabilir.

		3) Detached :  Bu durumda, nesne bir Hibernate session'ından ayrılmıştır. Artık bu
		session tarafından yönetilmiyor, ancak veritabanında hala bir karşılığı var. Ayrılmış
		durumdaki bir nesne, başka bir session'a bağlanarak kullanılabilir.

		4) Removed : obje remove yapıldığı zamanki durum.
*/
@Entity
public class Student13 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String name;

    private int MathGrade;

    //  // !!! Getter- Setter ************************

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathGrade() {
        return MathGrade;
    }

    public void setMathGrade(int mathGrade) {
        MathGrade = mathGrade;
    }

    @Override
    public String toString() {
        return "Student13{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", MathGrade=" + MathGrade +
                '}';
    }
}
