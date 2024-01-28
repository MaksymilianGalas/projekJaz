package com.example.students.data;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student {

    @Id
    @GeneratedValue     private UUID id;
    @Getter
    private String name;
    @Enumerated(EnumType.STRING)
    private StudentUnit unit;
    @Setter
    private Long index;
    @ManyToMany
    @JoinTable(name = "student_lecture",
            joinColumns = @JoinColumn(table = "student", name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(table = "lecture", name = "lecture_id", referencedColumnName = "id")
    )
    private List<Lecture> lecture;

    @OneToMany
    @Getter
    @Setter
    @JoinColumn(name = "friends")
    private List<Friends> friends;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String phoneNumber;
    @Setter
    @Getter
    @OneToMany(mappedBy = "student")
    private List<Assignment> assignments;
    public Student(String name, StudentUnit unit) {
        this.name = name;
        this.unit = unit;
    }

    public Student(String name, StudentUnit unit, Long index, String email, String phoneNumber) {
        this.name = name;
        this.unit = unit;
        this.index = index;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public Student(String name, StudentUnit unit, Long index) {
        this.name = name;
        this.unit = unit;
        this.index = index;
    }
}
