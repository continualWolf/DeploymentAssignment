package com.crs.service;

import com.crs.model.course;
import java.util.List;

public interface courseService {
    List<course> getAll();
    
    void save(course employee);
    
    course getById(long id);
    
    void deleteById(long id);
}
