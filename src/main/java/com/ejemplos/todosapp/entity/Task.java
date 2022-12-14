package com.ejemplos.todosapp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Task {
    @Id
    private String id;

    private String name;

    private String description;

    private String state;
}
