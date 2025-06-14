/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crs.repository;

import com.crs.model.course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bmwat
 */
public interface courseRepository extends JpaRepository<course, Long>{
    
}
