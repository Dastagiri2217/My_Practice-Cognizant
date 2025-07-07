package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Make a Class as an Entity -- Java Object <-to-> Database Table
@Data //Constructs all getter Setter methods
@AllArgsConstructor //Creates a Construcor with all arguments
@NoArgsConstructor // Same but no arguments
@Builder // Implements Builder Pattern 
@Table(name="tbl_Student",
uniqueConstraints= @UniqueConstraint(name="email_address_unique",columnNames="email_address"))
public class Student {
    @Id // to delcare an filed as an Primary Key we use @Id annotation
    @SequenceGenerator(
        name = "student_seq",
        sequenceName = "student_seq",
        allocationSize=1
        )
    @GeneratedValue(
        strategy= GenerationType.SEQUENCE,
        generator = "student_seq"
    )
    private long studentId;
    private String firstName;
    private String lastName;
    @Column(name="email_address",nullable=false)
    private String emailId;
    @Embedded
    private Guardian guardian;


}
