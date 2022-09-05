package com.ejemplos.todosapp.service;

import com.ejemplos.todosapp.entity.Task;
import com.ejemplos.todosapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Task findById(String id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        if(taskRepository.existsById(id)){
            taskRepository.delete(taskRepository.findById(id).orElse(null));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Task update(String id, Task task) {
        Task updatedTask = taskRepository.findById(id).orElse(null);
        if(updatedTask != null){
            updatedTask.setName(task.getName());
            updatedTask.setDescription(task.getDescription());
            updatedTask.setState(task.getState());
        }
        return taskRepository.save(updatedTask);
    }

    @Override
    public List<Task> completed() {
        List<Task> tasks = taskRepository.findAll();
        List<Task> completedTask = new ArrayList<>();
        for (Task t: tasks){
           if(t.getState().equals("completed")){
               completedTask.add(t);
           }
        }
        return completedTask;
    }

    @Override
    public List<Task> postponed() {
        List<Task> tasks = taskRepository.findAll();
        List<Task> postponedTask = new ArrayList<>();
        for (Task t: tasks){
            if(t.getState().equals("postponed")){
                postponedTask.add(t);
            }
        }
        return postponedTask;
    }

    @Override
    public List<Task> rejected() {
        List<Task> tasks = taskRepository.findAll();
        List<Task> rejected = new ArrayList<>();
        for (Task t: tasks){
            if(t.getState().equals("rejected")){
                rejected.add(t);
            }
        }
        return rejected;
    }
}
