
package com.crs.repository;

import com.crs.model.assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iAssignmentRepository  extends JpaRepository<assignment, Long> {
    
}
