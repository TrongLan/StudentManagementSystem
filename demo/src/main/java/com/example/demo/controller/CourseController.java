package com.example.demo.controller;

import com.example.demo.compositekey.CourseCompositeKey;
import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import java.util.List;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    
    @GetMapping("/courses")
    public String getAllCourses(Model model){
        model.addAttribute("courses", courseService.getAllCourse());
        return "courses";
    }
    
//    @GetMapping("/courses/new")
//    public String createNewCourse(Model mod){
//        Course c = new Course();
//        mod.addAttribute("course",c);
//        return "create_new_course";
//    }
    
    @PostMapping("/courses")
    public String saveNewCourse(@ModelAttribute("course") Course c){
        courseService.saveCourse(c);
        return "redirect:/courses";
    }
    @GetMapping("/{name}/{term}")
    public String getCourse(@PathVariable String name,@PathVariable String term, Model mod){
        CourseCompositeKey id = new CourseCompositeKey(name,term);
        mod.addAttribute("course", courseService.getCourseByID(id));
        return "student_list";
    }
}
