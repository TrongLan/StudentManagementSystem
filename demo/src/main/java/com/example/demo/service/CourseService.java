package com.example.demo.service;

import com.example.demo.compositekey.CourseCompositeKey;
import com.example.demo.entity.Course;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    Course saveCourse(Course c);
    Course getCourseByID(CourseCompositeKey id);
}
