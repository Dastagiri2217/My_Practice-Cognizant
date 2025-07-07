package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import  com.dailycodebuffer.spring.data.jpa.tutorial.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {
    
    @Autowired
    private CourseMaterialRepository repository;


    @Test
    public void saveCourseMaterial(){
        Course course =
             Course.builder().
             title("DSA").credits(6).build();

    CourseMaterial courseMaterial=
        CourseMaterial.builder().
        url("www.dsa.com").
        course(course).//forced to enter
        build();
        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials = repository.findAll();
           System.out.println("All COurses materials are  :"+courseMaterials);

    }
}
