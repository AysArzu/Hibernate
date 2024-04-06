package com.hb01.anotations;


import javax.persistence.*;

@Entity //!!!@Entity koyduğumuz sınıf, veritabanında bir tabloya karşılık gelecek
@Table(name = "t_student01") // tablo adını kendimiz customize ederek yazabiliyoruz
//!!! Eğer oluşacak tablo ismini değiştirmek istenirse name attribute ile
// bir tablo ismi verilir.
public class Student01 { // student01 şeklinde küçük harfle bir tablo oluşturur.

    @Id //!!! @Id --> primary key oluşmasını sağlıyor
    //@Column(name = "std_id")
    private int id;

    //Column annotationı zorunlu değil ancak customize edebilmek için gerekli
    @Column(name = "student_name", length = 20, nullable = false, unique = false)
    //!!! Javaca konuşurken name, SQL ce konuşurken student_name kullanmam lazım
    private String name; //255 karakter olur default postgresSQL de
    private String surname;

    //!!! @Transient --> veritabanı tablosunda "grade" adında bir kolon oluşturulmaz. kod içinde
    // kullanılmak için bir değişken oluştururuz ama bu sınıf DB ye kaydedileceği zaman
    //  ilgili tabloya kolon olarak eklenmez
    //@Transient //bu şekilde bir column oluşturulmuyor db de
    private int grade;

//    @Lob //Large object ile büyük datalar tutuluyor
//    private byte[] image;


    //Not: Getter - Setter **************************

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

//    public byte[] getImage() {
//        return image;
//    }
//
//    public void setImage(byte[] image) {
//        this.image = image;
//    }


    //Not : toStrig **************************
    @Override
    public String toString() {
        return "Student01{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", grade=" + grade +
                '}';
    }
}