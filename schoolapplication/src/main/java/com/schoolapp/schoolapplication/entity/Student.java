package com.schoolapp.schoolapplication.entity;

import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name="student_id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    @Column(name="student_name",length = 50)
    private String studentName;
    @Column(name="address",length = 100)
    private String address;
    @Column(name="mobile",length = 100)
    private int  mobile;
    @Column(name="active",columnDefinition = "TINYINT default 1")
    private boolean  active;

    public Student(int studentId, String studentName, String address, int mobile, boolean active) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.mobile = mobile;
        this.active = active;
    }
    public Student (String studentname, String address, int mobile, boolean active) {
        this.studentName = studentname;
        this.address = address;
        this.mobile = mobile;
        this.active = active;
    }
    public Student() {
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getMobile() {
        return mobile;
    }
    public void setMobile(int mobile) {
        this.mobile = mobile;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentId +
                ", studentname='" + studentName + '\'' +
                ", address='" + address + '\'' +
                ", mobile=" + mobile +
                ", active=" + active +
                '}';
    }
}
