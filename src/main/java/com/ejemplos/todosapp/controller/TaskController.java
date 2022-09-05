package com.ejemplos.todosapp.controller;

import com.ejemplos.todosapp.entity.Task;
import com.ejemplos.todosapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping()
    public List<Task> findAll(){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Task findById(@PathVariable String id){
        return taskService.findById(id);
    }

    @PostMapping("/")
    public Task create(@RequestBody Task task){
        return taskService.create(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        taskService.delete(id);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable String id, @RequestBody Task task){
        return taskService.update(id, task);
    }

    @GetMapping("/completed")
    public List<Task> completedTask(){
        return taskService.completed();
    }

    @GetMapping("/postponed") 
    public List<Task> postponedTask(){
        return taskService.postponed();
    }

    @GetMapping("/rejected")
    public List<Task> rejectedTask(){
        return taskService.rejected();
    }
}
