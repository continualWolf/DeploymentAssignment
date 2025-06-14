package com.crs.service;

import com.crs.model.assignment;
import com.crs.model.course;
import com.crs.repository.iAssignmentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class assignmentServiceImpl implements iAssignmentService {
    @Autowired        
    private iAssignmentRepository repo;

    @Override
    public List<assignment> getAll() {
        return repo.findAll();
    }

    @Override
    public void save(assignment ass) {
        repo.save(ass);
    }

    @Override
    public assignment getById(long id) {
        Optional<assignment> optional = repo.findById(id);
        
        assignment ass = null;
        
        if(optional.isPresent()){
            ass = optional.get();
        }else{
            throw new RuntimeException(" Assignment not found for id:: " + id);
        }
        
        return ass;
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Override
    public String getAssignmentDescription(long id) {
        assignment ass = repo.getById(id);
        return ass.getDescription();
    }
}