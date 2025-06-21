package com.example.deliverymatchs.Entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String lieu;
    private String etaps;
    private String destination;
    private String demensionMax;
    private Integer CapaciteDisponible;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "conducteur-id")
    private Conducteur conducteur;

    @OneToMany(mappedBy = "annonce")
    private List<Demande> demandes;

    public Annonce() {
    }

    public Annonce(Long id, String lieu, String etaps, String destination, String demensionMax, Integer capaciteDisponible, LocalDateTime date, Conducteur conducteur, List<Demande> demandes) {
        this.id = id;
        this.lieu = lieu;
        this.etaps = etaps;
        this.destination = destination;
        this.demensionMax = demensionMax;
        this.CapaciteDisponible = capaciteDisponible;
        this.date = date;
        this.conducteur = conducteur;
        this.demandes = demandes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getEtaps() {
        return etaps;
    }

    public void setEtaps(String etaps) {
        this.etaps = etaps;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDemensionMax() {
        return demensionMax;
    }

    public void setDemensionMax(String demensionMax) {
        this.demensionMax = demensionMax;
    }

    public Integer getCapaciteDisponible() {
        return CapaciteDisponible;
    }

    public void setCapaciteDisponible(Integer capaciteDisponible) {
        CapaciteDisponible = capaciteDisponible;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }




}
