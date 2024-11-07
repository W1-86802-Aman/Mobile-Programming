package com.sunbeaminfo.studentsapp;

import java.io.Serializable;

public class Student implements Serializable {
    private int rollno;
    private String name;
    private String course;
    private double marks;

    public Student() {
    }

    public Student(int rollno, String name, String course, double marks) {
        this.rollno = rollno;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

}
