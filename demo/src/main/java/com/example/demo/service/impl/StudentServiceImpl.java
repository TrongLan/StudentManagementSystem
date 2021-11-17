package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentInfo(String id) {
        return studentRepository.findById(id).get();
    }
    
}
