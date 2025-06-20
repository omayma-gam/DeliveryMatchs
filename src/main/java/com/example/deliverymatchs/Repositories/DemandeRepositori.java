package com.example.deliverymatchs.Repositories;

import com.example.deliverymatchs.Entitys.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeRepositori extends JpaRepository<Demande,Long> {
    List<Demande> findByExpediteurId(Long expediteurId);
    List<Demande> findByAnnonceId(Long annonceId);
}
