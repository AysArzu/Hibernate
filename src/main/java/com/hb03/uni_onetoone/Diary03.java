package com.hb03.uni_onetoone;

import javax.persistence.*;

@Entity
public class Diary03 {
    @Id
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name = "std_id")//Diary tablosunda ilişkili student_id yi
    // saklayacak column'un ismini std_id olarak değiştirdim .
    // ( olusacak kolonun Default değeri : student_id )
    private Student03 student; // student_id

    // Not: Getter - Setter **********************************

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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

    // Not: toString() ***************************************

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}



