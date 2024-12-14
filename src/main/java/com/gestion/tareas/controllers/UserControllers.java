package com.gestion.tareas.controllers;

import com.gestion.tareas.models.Users;
import com.gestion.tareas.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllers {

    @Autowired
    UsersService usersService;
    @GetMapping("/getusers")
    public List<Users> getUser(){
        return usersService.findUsers();
    }

    @PostMapping("/create")
    public Users createUser(@RequestBody Users user){
        return usersService.saveUsers(user);
    }



}
