package com.example.demo.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
//@IdClass(JoinCompositeKey.class)
@Table(name = "studies")
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "register_date", nullable = false)
    private Date register_date;
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student s;
    @ManyToOne
    @JoinColumn(name = "course_name", nullable = false)
    @JoinColumn(name = "term", nullable = false)
    private Course c;

    public Study() {
        
    }

    public Study(Date register_date, Student s, Course c) {
        this.register_date = register_date;
        this.s = s;
        this.c = c;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public Student getS() {
        return s;
    }

    public void setS(Student s) {
        this.s = s;
    }

    public Course getC() {
        return c;
    }

    public void setC(Course c) {
        this.c = c;
    }
}
