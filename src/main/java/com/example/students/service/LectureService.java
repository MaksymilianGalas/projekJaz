package com.example.students.service;

import com.example.students.data.Lecture;
import com.example.students.data.LectureRepository;
import com.example.students.exception.ResourceNotFoundException;
import com.example.students.mappery.LectureMapper;
import com.example.students.resource.LectureDto;
import com.example.students.resource.LectureResource;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;
    private final LectureMapper lectureMapper;

    public Lecture createLecture(Lecture lecture) {
        var lectureToSave = lectureMapper.toEntity(lecture);
        lectureRepository.save(lectureToSave);
        return lectureToSave;
    }

    public List<LectureDto> getAllLectures() {
        return lectureRepository.findAll()
                .stream()
                .map(lectureMapper::toDto)
                .collect(Collectors.toList());
    }

    public Lecture updateLecture(UUID id, LectureDto updateLecture) {
        Lecture existingLecture = lectureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lecture " + id + " not found"));

        lectureMapper.updateEntity(existingLecture, updateLecture);

        lectureRepository.save(existingLecture);
        return existingLecture;
    }



}