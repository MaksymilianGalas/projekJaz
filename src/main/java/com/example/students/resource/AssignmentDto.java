package com.example.students.resource;

import lombok.Data;

import java.util.UUID;

@Data
public class AssignmentDto {
    private UUID id;
    private String name;
    private String description;
    private String dueDate;
    private int weight;
    private int grade;

    public AssignmentDto(UUID id, String name, String description, String dueDate, int weight, int grade) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.weight = weight;
        this.grade = grade;
    }
}
