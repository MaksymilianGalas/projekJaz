package com.example.students.mappery;

import com.example.students.data.Lecture;

import com.example.students.resource.LectureDto;
import com.example.students.resource.LectureResource;
import org.springframework.stereotype.Component;

@Component
public class LectureMapper {

    public LectureDto toDto(Lecture lecture) {
        return new LectureDto(
                lecture.getId(),
                lecture.getName()
        );
    }

    public Lecture toEntity(Lecture createLecture) {
        Lecture lecture = new Lecture();
        lecture.setName(createLecture.getName());
        return lecture;
    }

    public void updateEntity(Lecture existingLecture, LectureDto updateLecture) {
    }
}