package com.crs.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "assignments")
public class assignment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "DateCreated")
    private LocalDateTime dateCreated;

    @Column(name = "DateDue")
    private LocalDateTime dueDate;

    @Column(name = "Description")
    private String description;

    @Column(name = "Document", columnDefinition = "TEXT")
    private String document;
    
    // Constructors
    public assignment() {
    }

    public assignment(String title, LocalDateTime dateCreated, LocalDateTime dateModified, LocalDateTime dueDate, String description, String document) {
        this.title = title;
        this.dateCreated = dateCreated;
        this.dueDate = dueDate;
        this.description = description;
        this.document = document;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public String getDescription() {
        return description;
    }

    public String getDocument() {
        return document;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
