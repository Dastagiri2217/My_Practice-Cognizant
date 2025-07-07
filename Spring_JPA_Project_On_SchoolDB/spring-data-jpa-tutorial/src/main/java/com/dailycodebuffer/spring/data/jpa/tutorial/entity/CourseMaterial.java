package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude="course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
        name="course_material_id_seq",
        sequenceName="course_material_id_seq",
        allocationSize=1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "course_material_id_seq"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
        cascade=CascadeType.ALL,
        fetch = FetchType.LAZY,
        optional=false
    )//Creating a one-to-one relationship with the Course entity becz a course material doesnt exist with out a course
    @JoinColumn(
        name="course_id",
        referencedColumnName="courseId"
    )//Mapping the columns of the two tables
    private Course course;
}
