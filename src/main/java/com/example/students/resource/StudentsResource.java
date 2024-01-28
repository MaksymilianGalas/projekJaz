package com.example.students.resource;

import com.example.students.data.FriendsRepository;
import com.example.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor
public class StudentsResource {

    private final StudentService studentService;
    private final FriendsRepository friendsRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody @Validated CreateStudent student) {
        studentService.createStudent(student);
    }


    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable UUID id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping
    public void deleteByName(String name) {
        studentService.deleteByName(name);
    }



    @PostMapping("/{name}")
    public List<StudentDto> getByName(@RequestParam String name) {
        return studentService.getNameBy(name);
    }
    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAllStudents();
    }

}
