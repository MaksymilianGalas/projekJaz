package com.example.students.resource;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
public class LectureDto {

    private UUID id;
    private String name;

    public LectureDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
