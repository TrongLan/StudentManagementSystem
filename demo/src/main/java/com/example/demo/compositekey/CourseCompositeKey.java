package com.example.demo.compositekey;

import java.io.Serializable;

public class CourseCompositeKey implements Serializable{
    private String name;
    private String term;

    public CourseCompositeKey(String name, String term) {
        this.name = name;
        this.term = term;
    }

    public CourseCompositeKey() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
    
}
