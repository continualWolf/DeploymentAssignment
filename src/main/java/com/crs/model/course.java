/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crs.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author bmwat
 */
@Entity
@Table(name = "course")
public class course implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "courseCode")
    private String courseCode;
    
    @Column(name = "courseName")
    private String courseName;
    
    @Column(name = "term")
    private int term;
    
    @Column(name = "creditUnit")
    private int creditUnit;
    
    public course(){
        
    }
    
    public course(long id, String courseCode, String courseName, int term, int creditUnit){
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.term = term;
        this.creditUnit = creditUnit;
    }
    
    public Long getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getCourseCode(){
        return this.courseCode;
    }
    
    public void setCourseCode(String code){
        this.courseCode = code;
    }
    
    public String getCourseName(){
        return this.courseName;
    }
    
    public void setCourseName(String name){
        this.courseName = name;
    }
    
    public int getTerm(){
        return this.term;
    }
    
    public void setTerm(int term){
        this.term = term;
    }
    
    public int getCreditUnit(){
        return this.creditUnit;
    }
    
    public void setCreditUnits(int units){
        this.creditUnit = units;
    }
    
    @Override
    public String toString(){
        return "Course \n Id = "+ this.id + " \n CourseCode = "+this.courseCode+"\n CourseName = "+this.courseName+"\n Term = "+this.term+"\n CreditUnit = "+this.creditUnit+".";
    }
}
