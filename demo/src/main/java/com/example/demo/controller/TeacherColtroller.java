package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;
import com.example.demo.service.TeacherService;
import com.example.demo.service.impl.TeacherServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherColtroller {
    private TeacherService teacherService;

    public TeacherColtroller(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    
    @GetMapping("/teachers")
    public String listTeacher(Model model){
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teachers";
    }
    
    @PostMapping("/teachers")
    public String saveNewCourse(@ModelAttribute("teacher") Teacher t){
        teacherService.saveTeacher(t);
        return "redirect:/teachers";
    }
    
    @GetMapping("teacher/info/{id}")
    public String showTeacherInfo(@PathVariable String id, Model mod){
        mod.addAttribute("teacher", teacherService.getTeacherInfo(id)) ;
        return "teacher_info";
    }
}
