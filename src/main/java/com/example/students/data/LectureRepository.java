package com.example.students.data;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, UUID> {

    List<Lecture> findByName(String name);

    @Transactional
    @Modifying
    @Query("DELETE FROM Lecture l WHERE l.id = :id")
    void deleteById(@Param("id") UUID id);
}