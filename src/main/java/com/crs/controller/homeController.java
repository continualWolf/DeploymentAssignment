/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crs.controller;

import com.crs.model.passwordHelper;
import com.crs.model.student;
import com.crs.service.iAssignmentService;
import com.crs.service.iStudentService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class homeController {
    @Autowired
    private iAssignmentService _assignmentService;
    @Autowired        
    private iStudentService repo;
    
    @GetMapping("/index")
    public String viewHomePage (HttpSession session, Model model) {
        student user = (student) session.getAttribute("loggedInUser");
        
        if (user != null) {
            model.addAttribute("user", user);
            return "test";
        }
        
        return "index";
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        try {
            // find student in database with the same email and password as inputs
            Optional<student> returnedStudent = repo.login(email, password);
            
            // if student is not null (it is found), return 200 status
            if (returnedStudent.isPresent()) {
                session.setAttribute("loggedInUser", returnedStudent.get());
                
                return ResponseEntity.ok().body("Login successful.");
            }
            
            // student is not found, login was unsuccessful return 401
            return ResponseEntity.status(401).body("Authentication failed: Invalid credentials. Hashed password: " + returnedStudent);
            
        } catch (Exception e) {
            // there was an unexpected error so return 500
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }
}
