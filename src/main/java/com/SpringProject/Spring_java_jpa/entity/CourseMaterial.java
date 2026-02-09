package com.SpringProject.Spring_java_jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "courseMaterialId_seq",
            sequenceName = "courseMaterialId_seq",
            allocationSize = 1
    )
   @GeneratedValue(
           strategy = GenerationType.SEQUENCE,
           generator = "courseMaterialId_seq"
   )
    private long courseMaterialId;
    private String url;

    @OneToOne
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
