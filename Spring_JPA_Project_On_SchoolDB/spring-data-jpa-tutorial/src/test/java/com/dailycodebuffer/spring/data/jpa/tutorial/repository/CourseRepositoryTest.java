package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void printCourses(){
        List<Course> courses = 
             courseRepository.findAll();
        System.out.println("Courses avialable are : "+courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = 
                        Teacher.builder()
                        .firstName("Sarkaar")
                        .lastName("Arjun")
                        .build();
        Course course = Course.builder().
                        title("Java ")
                        .credits(4)
                        .teacher(teacher)
                        .build();
        courseRepository.save(course);
    }
    

    @Test
    public void findAllPaginataions(){
        Pageable  firstPageWithTwoRecords =
                PageRequest.of(0, 2);
        // Pageable secondPagewithThreeRecords = 
        //         PageRequest.of(1, 3);


       List<Course> courses = courseRepository.findAll(firstPageWithTwoRecords)
       .getContent();

       Long totalElements = courseRepository.findAll(firstPageWithTwoRecords)
                            .getTotalElements();

        int totalPages = courseRepository.findAll(firstPageWithTwoRecords)
                        .getTotalPages();
       System.out.println("Total Pages in the base are  : "+totalPages);
       System.out.println("Total elements in firstPage are : "+totalElements);
       System.out.println("Coureses in First page : "+courses);
    }

    @Test
    public void findAllSortings(){
        Pageable sortingBasedOnCourseTitle = 
                     PageRequest.of(0, 2, Sort.by("title"));

        Pageable creditsByDescOrder = 
                     PageRequest.of(0, 2, Sort.by("credits").descending());

        // Pageable sorttitleAndcreditsByDescOrder = 
        //              PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credits")));

       List<Course> courses = courseRepository.findAll  (sortingBasedOnCourseTitle).getContent();
       System.out.println("Courses Sorted by Their Title : "+courses);

       List<Course> courses1 = courseRepository.findAll  (creditsByDescOrder).getContent();
       System.out.println("Courses Sorted by Their Credits in Descending Order : "+courses1);
    }
    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTwoRecords =
                    PageRequest.of(0,2);
        List<Course> courses = courseRepository.findByTitleContaining("f",firstPageTwoRecords).getContent();

        System.out.println("Custom Sorting : "+courses); //succes front-end and fullstack at output
    }
    
    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder()
                                 .firstName("Nagaraju")
                                 .lastName("Akula")
                                 .build();
        Student student = Student.builder()
                                 .firstName("Chatrapathi")
                                 .lastName("Kancham")
                                 .emailId("229x1a3239@gprec.ac.in")
                                 .build();
        Course course =  Course.builder()
                               .title("AI")
                               .credits(8)
                               .teacher(teacher)
                               .build();
        course.addStudents(student);
        courseRepository.save(course);
    }
}
