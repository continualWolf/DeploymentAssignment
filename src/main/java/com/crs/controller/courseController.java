/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crs.controller;

import com.crs.model.course;
import com.crs.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class courseController {
    @Autowired
    private courseService courseService;
    
    //Create method handler which will display a list of employees for home page index.html to display
    
    
    @GetMapping("/showNewCourseForm")
    public String showNewCourseForm(Model model){
        //Create a model to bind new employee data
       course employee = new course();
       model.addAttribute("course", employee);
       return "new_course";
    }
    
    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course")course course){
        //save employee tp database
        courseService.save(course);
        
        return "redirect:/index";
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model){
        //Get the employee from the service
        course employee = courseService.getById(id);

        //set employee as a model attribute to pre-populate th form
        model.addAttribute("employee", employee);
        
        return "update_course";
    }
    
    //delete employee by id
    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(@PathVariable( value = "id") long id){
        //Call delete method from the service
        this.courseService.deleteById(id);
        
        return "redirect:/index";
    }
}
