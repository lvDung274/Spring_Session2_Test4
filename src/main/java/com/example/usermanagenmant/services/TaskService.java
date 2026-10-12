package com.example.usermanagenmant.services;

import com.example.usermanagenmant.models.Task;
import com.example.usermanagenmant.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAllTasks();
    }
    public List<Task> findTasksWithSearch(String search) {
        List<Task> tasks = findAllTasks();

        if (search != null && !search.trim().isEmpty()) {
            String keyword = search.toLowerCase().trim();
            return tasks.stream()
                    .filter(task -> task.getTitle() != null &&
                            task.getTitle().toLowerCase().contains(keyword))
                    .collect(Collectors.toList());
        }

        return tasks;
    }
}