/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.crs.repository;

import com.crs.model.submittedAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iAssignmentSubmissionsRepository extends JpaRepository<submittedAssignment, Long> {
    
}
