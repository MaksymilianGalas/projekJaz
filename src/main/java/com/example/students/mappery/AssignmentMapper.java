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

    public Assignment toEntity(CreateAssignment createAssignment) {
        Assignment assignment = new Assignment();
        assignment.setName(createAssignment.getName());
        assignment.setDescription(createAssignment.getDescription());
        assignment.setDueDate(createAssignment.getDueDate());
        assignment.setWeight(createAssignment.getWeight());
        assignment.setGrade(createAssignment.getGrade());
        assignment.setStudent(createAssignment.getStudent());
        
        return assignment;
    }

    public void updateEntity(Assignment existingAssignment, AssignmentDto updateAssignment) {
    }
}