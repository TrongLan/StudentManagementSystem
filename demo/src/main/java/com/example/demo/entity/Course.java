package com.example.demo.entity;

import com.example.demo.compositekey.CourseCompositeKey;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@IdClass(CourseCompositeKey.class)
@Table(name = "courses")
public class Course {
    @Id
    @Column(updatable = false)
    private String name;
    @Id
    @Column(updatable = false)
    private String term;
    
    @Column(name = "fee", nullable = false)
    private int fee;
    @Column(name = "student_number", nullable = false)
    private int studentNumber;
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;
    
    @OneToMany(mappedBy = "c")
    private List<Study> joined;

    public Course() {
    }

    public Course(String term, String name, int fee, Teacher gv) {
        this.term = term;
        this.name = name;
        this.fee = fee;
        this.studentNumber = studentNumber;
        this.teacher = gv;
        this.joined = new ArrayList<>();
    }

    public String getTerm() {
            return term;
        }

    public void setTerm(String term) {
        this.term = term;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
    
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher gv) {
        this.teacher = gv;
    }
    
    public void addStudy(Study s){
        this.joined.add(s);
    }

    public List<Study> getJoined() {
        return joined;
    }

    public void setJoined(List<Study> joined) {
        this.joined = joined;
    }
}
