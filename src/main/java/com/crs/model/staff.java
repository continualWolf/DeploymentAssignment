/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crs.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "staff_members")
public class staff implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    private user user;

    public staff() {
    }

    public Long getStudentId() {
        return staffId;
    }

    public void setStaffId(Long studentId) {
        this.staffId = studentId;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }
}
