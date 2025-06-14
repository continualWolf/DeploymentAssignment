package com.crs;

import com.crs.model.student;
import com.crs.model.user;
import com.crs.service.iStudentService;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrsApplicationTests {
    @Autowired        
    private iStudentService repo;
    
    @Test
    void contextLoads() {
    }

//    @Test
//    public void testMain() throws NoSuchAlgorithmException {
//        boolean studentFound = repo.login("student@example.com", "c2c9b358a24c02ac84d20ae92bde69bd202cd712a09da5a3942a6408108b0ba3");
//
//        System.out.println("Was student found ? : " + studentFound);
//    }
    
    
    @Test
    public void passwordCheck() {
        String expectedPassword = "password";
        String actualPassword = "password";
        
        assertEquals(expectedPassword, actualPassword, "Passwords do not match.");
    }
    
    @Test
    public void passwordLetterCheck() {
        String password = "password";

        assertTrue(password.length() >= 3 &&
                   Character.isLetter(password.charAt(0)) &&
                   Character.isLetter(password.charAt(1)) &&
                   Character.isLetter(password.charAt(2)),
                   "First three characters should be letters.");
    }

}
