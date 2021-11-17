package com.example.demo.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "year_teaching")
    private int yearTeaching;
    @Column(name = "degree", nullable = false)
    private String degree;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "age")
    private int age;
    
    @OneToMany(mappedBy = "teacher")
    private List<Course> course_list;
    public Teacher() {
    }

    public Teacher(String id, String name, Date birthday, int age, String phone_number, String email, int yearTeaching, String degree) {
        this.id = id;
        this.name = name;
        this.yearTeaching = yearTeaching;
        this.degree = degree;
        this.phoneNumber = phone_number;
        this.email = email;
        this.birthday = birthday;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearTeaching() {
        return yearTeaching;
    }

    public void setYearTeaching(int yearTeaching) {
        this.yearTeaching = yearTeaching;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }    

    public List<Course> getCourse_list() {
        return course_list;
    }

    public void setCourse_list(List<Course> course_list) {
        this.course_list = course_list;
    }
    
}
