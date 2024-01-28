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
public interface AssignmentRepository extends JpaRepository<Friends, UUID> {

    @Query("SELECT f FROM Friends f WHERE f.name = :name")
    List<Friends> findFriendsByName(@Param("name") String name);
    List<Friends> findAssignmentsByAssignment(Assignment assignment);
    @Modifying
    @Transactional
    @Query("DELETE FROM Friends f WHERE f.name = :name")
    void deleteFriendsByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM Friends f WHERE f.id = :id")
    void deleteFriendsById(@Param("id") UUID id);

    @Query("SELECT f FROM Friends f WHERE f.id = :id")
    List<Friends> findFriendsById(@Param("id") UUID id);

}
