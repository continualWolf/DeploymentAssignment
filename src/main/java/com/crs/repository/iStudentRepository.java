package com.crs.repository;

import com.crs.model.student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface iStudentRepository extends JpaRepository<student, Long> {
    @Query(value = "SELECT * FROM students s INNER JOIN users u ON s.userid = u.id WHERE u.email = :email AND u.hashedpassword = :hashedPassword", nativeQuery = true)
    Optional<student> findByEmailAndHashedPassword(@Param("email") String email, @Param("hashedPassword") String hashedPassword);
}
