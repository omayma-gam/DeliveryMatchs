package com.example.deliverymatchs.DTO;

import com.example.deliverymatchs.Entitys.Role;

import java.io.Serializable;


public class UtilisateursDto implements Serializable {
     Long id;
    String name;
    String email;
    String password;

    Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}