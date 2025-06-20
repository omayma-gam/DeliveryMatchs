package com.example.deliverymatchs.Repositories;

import com.example.deliverymatchs.Entitys.Annonce;
import com.example.deliverymatchs.Entitys.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce,Long> {

    List<Annonce> findByConducteurId(Long conducteurId);
    List<Annonce> findByDemandes(List<Demande>demandes);
}
