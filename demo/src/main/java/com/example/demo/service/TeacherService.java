package com.example.demo.service;

import com.example.demo.entity.Teacher;
import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher saveTeacher(Teacher t);
    Teacher getTeacherInfo(String id);
}
