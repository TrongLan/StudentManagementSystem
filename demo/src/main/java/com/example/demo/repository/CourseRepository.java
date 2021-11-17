package com.example.demo.repository;

import com.example.demo.compositekey.CourseCompositeKey;
import com.example.demo.entity.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, CourseCompositeKey>{

}
