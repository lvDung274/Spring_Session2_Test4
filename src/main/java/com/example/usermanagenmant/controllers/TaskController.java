package com.example.usermanagenmant.controllers;

import com.example.usermanagenmant.models.Task;
import com.example.usermanagenmant.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAllTasks(
            @RequestParam(value = "search", required = false) String search
    ) {
        List<Task> tasks = taskService.findTasksWithSearch(search);
        return ResponseEntity.ok(tasks);
    }
}