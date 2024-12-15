package com.gestion.tareas.services;

import com.gestion.tareas.models.Tasks;
import com.gestion.tareas.models.Users;
import com.gestion.tareas.repositories.TasksRepository;
import com.gestion.tareas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksServiceImpl implements TasksService{
    @Autowired
    TasksRepository tasksRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public Tasks findTasksById(Long id) {
        return tasksRepository.findById(id).get();
    }

    @Override
    public List<Tasks> findTasks(Long id) {
        return tasksRepository.findTasksByUserId(id);
    }

    @Override
    public Tasks saveTask(Tasks task,Long id) {
        Users user = userRepository.findById(id).orElseThrow();
        task.setUser(user);
        return tasksRepository.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        tasksRepository.deleteById(id);
    }

    @Override
    public Tasks taskUpdate(Tasks task) {
        return tasksRepository.save(task);
    }
}
