package com.gestion.tareas.services;

import com.gestion.tareas.models.Users;
import com.gestion.tareas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    UserRepository userRepository;
    @Override
    public Optional<Users> findUsersById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Users> findUsers() {
        return List.of();
    }

    @Override
    public Users saveUsers(Users users) {
        return userRepository.save(users);
    }

    @Override
    public void deleteUsersById(Long id) {

    }
}
