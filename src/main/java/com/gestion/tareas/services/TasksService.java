package com.gestion.tareas.services;

import com.gestion.tareas.models.Tasks;

import java.util.List;

public interface TasksService {
    Tasks findTasksById(Long id);
    List<Tasks> findTasks(Long id);
    Tasks saveTask(Tasks task, Long id);
    void deleteTaskById(Long id);
    Tasks taskUpdate(Tasks task);

}
