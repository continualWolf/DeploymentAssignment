/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crs.service;

import com.crs.model.course;
import com.crs.repository.courseRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bmwat
 */
@Service
public class courseServiceImpl implements courseService {
    @Autowired
    private courseRepository courseRepository;
    
    @Override
    public List<course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public void save(course employee) {
        courseRepository.save(employee);
    }

    @Override
    public course getById(long id) {
        Optional<course> optional = courseRepository.findById(id);
        
        course course = null;
        
        if(optional.isPresent()){
            course = optional.get();
        }else{
            throw new RuntimeException(" Employee not found for id:: " + id);
        }
        
        return course;
    }

    @Override
    public void deleteById(long id) {
        courseRepository.deleteById(id);
    }
    
}
