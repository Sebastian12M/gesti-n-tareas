package com.gestion.tareas.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String  email;
    private String password;
    @Column(name = "is_enabled")
    boolean isEnabled;
    @Column(name = "account_not_expired")
    boolean accountNotExpired;
    @Column(name = "account_locked")
    boolean accountLocked;
    @Column(name = "credentials_not_expired")
    boolean credentialsNotExpired;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "user", orphanRemoval = true)
    private List<Tasks> tasks;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Roles> roles;

    public Users() {
    }

    public Users(Long id, String username, String email, String password, boolean isEnabled, boolean accountNotExpired, boolean accountLocked, boolean credentialsNotExpired, List<Tasks> tasks, List<Roles> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.isEnabled = isEnabled;
        this.accountNotExpired = accountNotExpired;
        this.accountLocked = accountLocked;
        this.credentialsNotExpired = credentialsNotExpired;
        this.tasks = tasks;
        this.roles = roles;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isCredentialsNotExpired() {
        return credentialsNotExpired;
    }

    public void setCredentialsNotExpired(boolean credentialsNotExpired) {
        this.credentialsNotExpired = credentialsNotExpired;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public boolean isAccountNotExpired() {
        return accountNotExpired;
    }

    public void setAccountNotExpired(boolean accountNotExpired) {
        this.accountNotExpired = accountNotExpired;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
