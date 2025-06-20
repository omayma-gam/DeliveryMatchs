package com.example.deliverymatchs.Entitys;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
public class Admin extends Utilisateurs{
    public Admin() {
        this.setRole(Role.ADMIN);
    }
}
