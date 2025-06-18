package com.example.deliverymatchs.Repositories;

import com.example.deliverymatchs.Entitys.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateurs,Long> {
    Utilisateurs findByEmail(String email);
}
