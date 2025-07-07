package com.dailycodebuffer.spring.data.jpa.tutorial.repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher() {
        Course course = 
                       Course.builder()
                       .title("Front-End")
                       .credits(5)
                       .build();
        Course course1 = 
                        Course.builder().
                        title("FullStack")
                        .credits(4)
                        .build();
        Teacher teacher = Teacher.builder()
                                 .firstName("Bhumitra")
                                 .lastName("Sharma")
                                 //.courses(List.of(course,course1))
                                 .build();
        teacherRepository.save(teacher);
    }

}
