/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crs.controller;

import com.crs.model.assignment;
import com.crs.model.student;
import com.crs.model.submittedAssignment;
import com.crs.service.iAssignmentService;
import com.crs.service.iAssignmentSubmissionsService;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class assignmentController {
    @Autowired
    private iAssignmentSubmissionsService _assignmentSubService;
    
    @Autowired
    private iAssignmentService _assignmentService;
    
    @GetMapping("/assignments")
    public String viewAssignments (HttpSession session, Model model){
        student user = (student) session.getAttribute("loggedInUser");
        
        model.addAttribute("listAssignments", _assignmentSubService.getAllByStudentIdGroupByAssignmentId(user.getStudentId()));
        
        return "assignments";
    }
    
    @GetMapping("/getAssignmentDetails/{id}")
    @ResponseBody
    public ResponseEntity<?> getAssignmentDescription(@PathVariable("id") long id) {
        try {
            assignment foundAssignment = _assignmentService.getById(id);
            
            if (foundAssignment == null) {
                return ResponseEntity.status(404).body("Assignment details could not be found.");
            }
            
            Map<String, Object> response = Map.of(
                "description", foundAssignment.getDescription(),
                "dueDate", foundAssignment.getDueDate(),
                "title", foundAssignment.getTitle()
            );
            
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }
    
    @PostMapping("/submitAssignment")
    public ResponseEntity<?> submitAssignment(@RequestParam String Document, @RequestParam int AssignmentId, HttpSession session) {
        try {
            student user = (student) session.getAttribute("loggedInUser");
            
            _assignmentSubService.save(user.getStudentId(), AssignmentId, Document);
            
            return ResponseEntity.ok().body("Submission successful.");
        } catch (Exception e) {
            // there was an unexpected error so return 500
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }

}
