package com.gestion.tareas.services;

import com.gestion.tareas.models.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    Optional<Users> findUsersById(Long id);
    List<Users> findUsers();
    Users saveUsers(Users users);
    void deleteUsersById(Long id);

}
