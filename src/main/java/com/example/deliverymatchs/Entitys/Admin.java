package com.example.deliverymatchs.Entitys;

import jakarta.persistence.Entity;

@Entity
public class Admin extends Utilisateurs{

    public Admin() {
        this.setRole(Role.ADMIN);
    }
    
}
