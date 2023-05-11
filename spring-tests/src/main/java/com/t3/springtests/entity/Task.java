package com.t3.springtests.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tasks")
@Data @NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String description;

    @Column(name = "is_done")
    private boolean isDone;

    public Task(String name, String description, boolean isDone) {
        this.name = name;
        this.description = description;
        this.isDone = isDone;
    }
    
}
