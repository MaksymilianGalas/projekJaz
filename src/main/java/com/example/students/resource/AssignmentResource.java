package com.example.students.resource;

import lombok.Data;

import java.util.UUID;

@Data
public class AssignmentResource {
    private String name;
    private String description;
    private String dueDate;
    private int weight;
    private int grade;
    private UUID studentId;
}
