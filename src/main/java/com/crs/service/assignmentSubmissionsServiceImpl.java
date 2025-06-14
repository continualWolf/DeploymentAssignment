/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crs.service;

import com.crs.model.assignment;
import com.crs.model.submittedAssignment;
import com.crs.repository.iAssignmentRepository;
import com.crs.repository.iAssignmentSubmissionsRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author bmwat
 */
@Service
public class assignmentSubmissionsServiceImpl implements iAssignmentSubmissionsService {
    @Autowired        
    private iAssignmentSubmissionsRepository repo;
    @Autowired
    private iAssignmentService _assignmentService;

    @Override
    public List<submittedAssignment> getAll() {
        return repo.findAll();
    }

    @Override
    public List<submittedAssignment> getAllByStudentId(long studentId) {
        List<submittedAssignment> allAssignments = repo.findAll();
        List<submittedAssignment> filteredAssignments = new ArrayList<>();

        for (submittedAssignment assignment : allAssignments) {
            if (assignment.getStudentId() == studentId) {
                filteredAssignments.add(assignment);
            }
        }

        return filteredAssignments;
    }
    
    @Override
    public Map<Long, Object[]> getAllByStudentIdGroupByAssignmentId(long studentId) {
        List<submittedAssignment> allAssignments = repo.findAll();
        Map<Long, Object[]> groupedAssignments = new HashMap<>();

        // loop through all submissions
        for (submittedAssignment assignment : allAssignments) {
            // If the submission is attached to the provided student id
            if (assignment.getStudentId() == studentId) {
                long assignmentId = assignment.getAssignment().getId();
                if (!groupedAssignments.containsKey(assignmentId)) {
                    groupedAssignments.put(assignmentId, new Object[] {assignment, 0});
                }
                Object[] details = groupedAssignments.get(assignmentId);
                details[1] = (Integer) details[1] + 1;  // Increment the submission count
            }
        }

        return groupedAssignments;
    }


    @Override
    public void save(long studentId, long assignmentId, String document) {
        List<submittedAssignment> allSubmissions = repo.findAll();
        submittedAssignment targetSubmission = null;

        // Loop through all submissions to check if there is an existing submission
        for (submittedAssignment submission : allSubmissions) {
            if (submission.getStudentId() == studentId && submission.getAssignment().getId() == assignmentId && submission.getStatus() == 1) {
                targetSubmission = submission;
                break;
            }
        }

        // if a submission exists then alter it else create a new submission
        if (targetSubmission != null) {
            targetSubmission.setDocument(document);
            targetSubmission.setStatus(2);
        } else {
            assignment retreivedAssignment = _assignmentService.getById(assignmentId);
            
            targetSubmission = new submittedAssignment();
            
            targetSubmission.setStudentId(studentId);
            targetSubmission.setAssignment(retreivedAssignment);
            targetSubmission.setDocument(document);
            targetSubmission.setStatus(2); 
        }

        repo.save(targetSubmission);
    }

    @Override
    public submittedAssignment getById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
