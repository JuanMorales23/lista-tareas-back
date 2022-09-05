package com.ejemplos.todosapp.service;

import com.ejemplos.todosapp.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task findById(String id);
    Task create(Task task);
    void delete(String id);
    Task update(String id, Task task);
    List<Task> completed();
    List<Task> postponed();
    List<Task> rejected();
}
