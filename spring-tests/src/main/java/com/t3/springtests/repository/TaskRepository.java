package com.t3.springtests.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t3.springtests.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

    Optional<Task> findByName(String name);
    
}
