package com.crs.model;

import static com.crs.model.passwordHelper.hashPassword;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class user implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FirstName")
    private String firstName;
    
    @Column(name = "LastName")
    private String lastName;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "HashedPassword")
    private String hashedPassword;
    
    @Column(name = "DateCreated")
    private LocalDateTime dateCreated;
    
    @Column(name = "DateModified")
    private LocalDateTime dateModified;
    
    @Column(name = "LastLoginDate")
    private LocalDateTime lastLoginDate;
    
    // Constructors
    public user() {
       
    }

    public user(String firstName, String lastName, String email, LocalDateTime dateCreated, LocalDateTime dateModified, LocalDateTime lastLoginDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.lastLoginDate = lastLoginDate;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getPassword() {
        return hashedPassword;
    }
    
    public void setPassword(String password) throws NoSuchAlgorithmException{
        this.hashedPassword = hashPassword(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
    
    public String getHashedPassword(){
        return this.hashedPassword;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", email='" + email + '\'' +
               ", dateCreated=" + dateCreated +
               ", dateModified=" + dateModified +
               ", lastLoginDate=" + lastLoginDate +
               '}';
    }
}