package com.gestion.tareas.services;

import com.gestion.tareas.models.Users;
import com.gestion.tareas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=usersRepository.findByUsername(username).orElseThrow();
        List<SimpleGrantedAuthority>authorities= new ArrayList<>();

//        Users usuario = user.orElseThrow(()->new UsernameNotFoundException("usuario no encontrado"));
        user.getRoles().forEach(roles -> System.out.println(roles.getName()));
        System.out.println(user.getPassword());
        user.getRoles().forEach(roles->authorities.add(new SimpleGrantedAuthority("ROLE_".concat(roles.getName()))));

        authorities.forEach(rol-> System.out.println(rol.getAuthority()));

        return new User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNotExpired(),
                user.isCredentialsNotExpired(),
                user.isAccountLocked(),
                authorities



        );
    }
}
