package com.empresa.funcionarios.domain.model;

import java.util.Objects;
import java.util.UUID;

public class User {

    private final UUID id;
    private final String email;
    private String password;
    private String role;
    private boolean active;

    public User(UUID id, String email, String password, String role, boolean active) {
        this.id = id;
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
        this.role = role != null ? role : "USER";
        this.active = active;
    }

    public static User create(String email, String password, String role) {
        return new User(UUID.randomUUID(), email, password, role, true);
    }

    public void deactivate() {
        this.active = false;
    }

    public void changePassword(String newPassword) {
        this.password = Objects.requireNonNull(newPassword);
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }
}
