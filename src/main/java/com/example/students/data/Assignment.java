package com.example.students.data;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Assignment {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    private String dueDate;
    private int weight;
    private int grade;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}