package com.example.deliverymatchs.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


public class AnnonceDto implements Serializable {
    Long id;
    String lieu;
    String etaps;
    String destination;
    String demensionMax;
    String CapaciteDisponible;
    LocalDateTime date;

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

    public String getCapaciteDisponible() {
        return CapaciteDisponible;
    }

    public void setCapaciteDisponible(String capaciteDisponible) {
        CapaciteDisponible = capaciteDisponible;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}