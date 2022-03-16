package com.springehcache.controller;

import com.springehcache.model.Task;
import com.springehcache.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    private final TaskService taskService;

    @GetMapping(path = "/all")
    public List<Task> getAllTasks() {
        log.info("call taskService.findAll");
        return taskService.findAll();
    }

    @GetMapping(path = "/all/{userId}")
    public List<Task> getAllTasksByUserId(@PathVariable Integer userId) {
        log.info("call taskService.findAllByUserId");
        return taskService.findAllByUserId(userId);
    }

}
