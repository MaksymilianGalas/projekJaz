package com.example.students.mappery;

import com.example.students.data.Assignment;
import com.example.students.resource.AssignmentDto;

import com.example.students.resource.CreateAssignment;
import org.springframework.stereotype.Component;

@Component
public class AssignmentMapper {

    public AssignmentDto toDto(Assignment assignment) {
        return new AssignmentDto(
                assignment.getId(),
                assignment.getName(),
                assignment.getDescription(),
                assignment.getDueDate(),
                assignment.getWeight(),
                assignment.getGrade()
        );
    }


}