package com.crs.model;

import java.io.Serializable;
import javax.persistence.*;

import javax.persistence.*;
import java.io.Serializable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student_assignment_submissions")
public class submittedAssignment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "StudentId")
    private long studentId;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AssignmentId", referencedColumnName = "Id")
    private assignment assignment;
    
    @Column(name = "Status")
    private int status;
    
    @Column(name = "Grade")
    private int grade;
    
    @Column(name = "SubmissionDocument")
    private String document;

    // Constructors
    public submittedAssignment() {
    }

    public submittedAssignment(int status, int grade, String document) {
        this.status = status;
        this.grade = grade;
        this.document = document;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public void setStudentId(long id){
        this.studentId = id;
    }
    
    public long getStudentId(){
        return this.studentId;
    }
    
    public assignment getAssignment(){
        return this.assignment;
    }
    
    public void setAssignment(assignment ass){
        this.assignment = ass;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}