package com.example.students.data;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    @Modifying
    @Transactional
    void deleteByName(String name);

    @Query("select max(s.index) from Student s")
    Optional<Long> findMaxIndex();

    List<Student> findByName(String name);
    @Query("SELECT s FROM Student s WHERE s.id = :id")
    Optional<Student> findById(@Param("id") UUID id);

    List<Student> findByUnitAndName(StudentUnit unit, String name);

    default List<Student> findFromGdanskByName(String name) {
        return findByUnitAndName(StudentUnit.GDANSK, name);
    }

}
