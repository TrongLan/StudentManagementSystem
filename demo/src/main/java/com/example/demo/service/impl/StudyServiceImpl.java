package com.example.demo.service.impl;

import com.example.demo.entity.Study;
import com.example.demo.repository.StudyRepository;
import com.example.demo.service.StudyService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudyServiceImpl implements StudyService{
    
    private StudyRepository studyRepo;
    public StudyServiceImpl(StudyRepository studyRepo) {
        this.studyRepo = studyRepo;
    }
    @Override
    public List<Study> getAllStudies() {
        return studyRepo.findAll();
    }
    
//    @Override
//    public Study getStudyInfo(Long id) {
//        return studyRepo.findById(id).get();
//    }
}
