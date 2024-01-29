package com.example.students.front;

import com.example.students.data.Assignment;
import com.example.students.data.Lecture;
import com.example.students.resource.CreateFriend;
import com.example.students.resource.CreateStudent;
import com.example.students.resource.StudentDto;
import com.example.students.service.FriendsService;
import com.example.students.service.LectureService;
import com.example.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/api", method = RequestMethod.POST)
@RequiredArgsConstructor
public class PageController {

    private final FriendsService friendsService;
    private final LectureService lectureService;
    private final StudentService studentService;
    @GetMapping
    public String getStudentsPage(Model model) {
        var students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "index";
    }
    @PostMapping("/friend/add")
    public String addFriend(@RequestBody CreateFriend createFriend) {
        friendsService.addFriend(createFriend);
        return "friendAddedPage";
    }

    @PostMapping("/lecture/add")
    public String createLecture(@RequestBody Lecture lecture) {
        lectureService.createLecture(lecture);
        return "lectureCreatedPage";
    }

    @PostMapping("/student/add")
    public String createStudent(@RequestBody CreateStudent createStudent) {
        studentService.createStudent(createStudent);
        return "studentCreatedPage";
    }

    @GetMapping("/student/show")
    public String searchAllStudents(Model model) {
        var students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student";
    }
    @GetMapping("/friend/show")
    public String searchAllFriends(Model model) {
        var friends = friendsService.getAllFriends();
        model.addAttribute("friends", friends);
        return "friend";
    }

    @GetMapping("/student/show/json")
    @ResponseBody
    public List<StudentDto> searchAllStudentsJson() {
        return studentService.getAllStudents();
    }
    @PostMapping("/student/addAssignment")
    public String addAssignmentToStudent(@RequestParam UUID studentId, @RequestBody Assignment assignment) {
        studentService.addAssignmentToStudent(studentId, assignment);
        return "redirect:/api/student/show";
    }


}