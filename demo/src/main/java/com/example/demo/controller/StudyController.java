package com.example.demo.controller;

import com.example.demo.service.StudyService;
import static org.hibernate.criterion.Projections.id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudyController {
    private StudyService studyService;

    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }
    @GetMapping("/studies")
    public String showAllStudies(Model mod){
        mod.addAttribute("studies", studyService.getAllStudies());
        return "studies";
    }
}
