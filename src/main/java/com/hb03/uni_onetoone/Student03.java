package com.hb03.uni_onetoone;

import javax.persistence.*;

@Entity
public class Student03 {
    @Id
    private int id;

    @Column(name = "std_name")
    private String name;

    private int grade;

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    // Not: toString() ************************

    @Override
    public String toString() {
        return "Student03{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}