package com.example.deliverymatchs.Entitys;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Expediteur extends Utilisateurs{

    @OneToMany(mappedBy = "expediteur")
    private List<Demande> demandes;

    public Expediteur() {

    }

    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }
}
