package com.crs.service;

import com.crs.model.student;
import java.util.List;
import java.util.Optional;

public interface iStudentService {
    List<student> getAll();
    
    void save(student ass);
    
    student getById(long id);
    
    Optional<student> login(String email, String password);
}