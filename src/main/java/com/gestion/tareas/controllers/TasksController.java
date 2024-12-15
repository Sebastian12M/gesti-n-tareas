package com.gestion.tareas.controllers;

import com.gestion.tareas.models.Tasks;
import com.gestion.tareas.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    TasksService tasksService;
    @GetMapping("/get/{id}")
    public List<Tasks> getTasks(@PathVariable Long id) {
        return tasksService.findTasks(id);
    }

    @GetMapping("/getbyid/{id}")
    public Tasks getTaskById(@PathVariable Long id) {
        return tasksService.findTasksById(id);
    }

    @PostMapping("{id}")
    public Tasks create(@RequestBody Tasks tasks, @PathVariable Long id) {
        return tasksService.saveTask(tasks, id);
    }

    @PutMapping("/update")
    public Tasks update(@RequestBody Tasks tasks) {
        return tasksService.taskUpdate(tasks);
    }

}
