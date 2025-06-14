package com.crs.service;

import static com.crs.model.passwordHelper.hashPassword;
import com.crs.model.student;
import com.crs.repository.courseRepository;
import com.crs.repository.iStudentRepository;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentServiceImpl implements iStudentService {
    @Autowired
    private iStudentRepository _iStudentRepository;
    
    @Override
    public List<student> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(student ass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public student getById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<student> login(String email, String password) {
        String hashedPassword = "";

        try {
            hashedPassword = hashPassword(password);
            System.out.println("PASSWORD HASH :" + hashedPassword);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(studentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Optional.empty(); // Return an empty Optional if hashing fails
        }

        List<student> allStudents = _iStudentRepository.findAll();

        for (student student : allStudents) {
            if (student.getUser().getEmail().equals(email) && student.getUser().getHashedPassword().equals(hashedPassword)) {
                return Optional.of(student);
            }
        }

        return Optional.empty();
    }
}
