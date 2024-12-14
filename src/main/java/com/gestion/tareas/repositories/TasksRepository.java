package com.gestion.tareas.repositories;

import com.gestion.tareas.models.Tasks;
import com.gestion.tareas.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TasksRepository extends JpaRepository<Tasks,Long> {

    List<Tasks> findTasksByUserId(Long userId);

}
