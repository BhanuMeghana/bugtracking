package com.example.bugtracker.repository;

import com.example.bugtracker.model.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepository extends JpaRepository<Bug, Long> {
    List<Bug> findByStatus(String status);
    List<Bug> findByAssignedUserId(Long userId);
    List<Bug> findByPriority(String priority);
    List<Bug> findBySeverity(String severity);
}
