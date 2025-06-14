package com.crs.service;

import com.crs.model.submittedAssignment;
import java.util.List;
import java.util.Map;

public interface iAssignmentSubmissionsService {
    List<submittedAssignment> getAll();
    
    List<submittedAssignment> getAllByStudentId(long studentId);
    
    Map<Long, Object[]> getAllByStudentIdGroupByAssignmentId(long studentId) ;
    
    void save(long studentId, long assignmentId, String document);
    
    submittedAssignment getById(long id);
    
    void deleteById(long id);
}