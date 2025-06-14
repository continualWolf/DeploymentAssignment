package com.crs.service;

import com.crs.model.assignment;
import com.crs.model.course;
import java.util.List;

public interface iAssignmentService {
    List<assignment> getAll();
    
    void save(assignment ass);
    
    assignment getById(long id);
    
    void deleteById(long id);
    
    String getAssignmentDescription(long id);
}
