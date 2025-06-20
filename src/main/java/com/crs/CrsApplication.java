package com.crs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CrsApplication {
    
    public static void main(String[] args){
        
        SpringApplication.run(CrsApplication.class, args);

    }
    
}
