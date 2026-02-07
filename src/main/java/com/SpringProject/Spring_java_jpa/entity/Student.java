package com.SpringProject.Spring_java_jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Builder.Default
    private Long studentId = 0L;
    private String firstName;
    private String lastName;
    private String emailId;

    @Embedded
    public Guardian guard;
}
