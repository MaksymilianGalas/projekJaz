package com.example.students.resource;


import com.example.students.data.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAssignment {

    private String name;
    private String description;
    private String dueDate;
    private int weight;
    private int grade;
    private Student student;


}