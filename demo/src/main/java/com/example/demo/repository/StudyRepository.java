package com.example.demo.repository;

import com.example.demo.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long>{    
}
