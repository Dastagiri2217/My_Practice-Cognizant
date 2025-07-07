package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name); 
    public List<Student> findByGuardianName(String guardianName);

    //JPQL
    @Query("select s from Student s WHERE s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);
     //JPQL
    @Query("select s.firstName from Student s WHERE s.emailId = ?1")
    String  getStudentFirstNametByEmailAddress(String emailId);
    
    //Native Query
    @Query(value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1", nativeQuery=true)
    Student getStudentEmailAddressByNativeQuery(String emailId);

    @Query(value = "SELECT s.last_Name FROM tbl_Student s WHERE s.first_Name = ?1", nativeQuery=true)
    String getStudentLastNameByNativeQuery(String firstName);

    //Native + Named Param
    @Query(value = "SELECT s.last_name FROM tbl_Student s WHERE s.first_name = :firstName", nativeQuery=true)
    String getStudentLastNameByNativeQueryNamed(@Param("firstName") String firstName);

    @Modifying
    @Transactional
    @Query(
        value = "update tbl_Student set first_name = ?1 where email_address = ?2 ",
        nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName,String emailId);

}
