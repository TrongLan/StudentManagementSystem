package com.example.demo.service.impl;

import com.example.demo.compositekey.CourseCompositeKey;
import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{
    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public Course saveCourse(Course c) {
        return courseRepository.save(c);
    }

    @Override
    public Course getCourseByID(CourseCompositeKey id) {
        return courseRepository.findById(id).get();
    }

}
