package com.gestion.tareas.services;

import com.gestion.tareas.models.Roles;
import com.gestion.tareas.models.Users;
import com.gestion.tareas.repositories.RoleRepository;
import com.gestion.tareas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;
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
        Optional<Roles> rol = roleRepository.findByName("USER");

        rol.ifPresent(roles->{
            users.setRoles(List.of(roles));
        });


        return userRepository.save(users);
    }

    @Override
    public void deleteUsersById(Long id) {

    }
}
