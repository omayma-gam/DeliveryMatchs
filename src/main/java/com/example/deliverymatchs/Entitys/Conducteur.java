package com.example.deliverymatchs.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Conducteur extends Utilisateurs{

    @OneToMany(mappedBy = "conducteur")
    private List<Annonce> annonces;

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }
}
