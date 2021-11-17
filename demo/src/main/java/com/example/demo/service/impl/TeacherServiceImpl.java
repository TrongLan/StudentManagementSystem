package com.example.demo.service.impl;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.service.TeacherService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService{
    private TeacherRepository teacherRepo;

    public TeacherServiceImpl(TeacherRepository teacherRepo) {
        this.teacherRepo = teacherRepo;
    }
    
    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher saveTeacher(Teacher t) {
        return teacherRepo.save(t);
    }

    @Override
    public Teacher getTeacherInfo(String id) {
        return teacherRepo.findById(id).get();
    }
    
    
}
