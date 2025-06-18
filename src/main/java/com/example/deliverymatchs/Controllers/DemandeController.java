package com.example.deliverymatchs.Controllers;

import com.example.deliverymatchs.DTO.DemandeDto;
import com.example.deliverymatchs.Services.DemandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Demande")
public class DemandeController {

    private final DemandeService demandeService;

    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }


    @PostMapping()
    public DemandeDto addDemande(@RequestBody DemandeDto demandeDto) {
        return demandeService.AjouterDemande(demandeDto);
    }
    @GetMapping
    public List<DemandeDto> getAllUser(){
        return demandeService.listeDemande();
    }
    @PutMapping("/{id}")
    public DemandeDto updatUser(@PathVariable Long id , @RequestBody DemandeDto annonceDto) {
        return demandeService.modifierDemande(id,annonceDto);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id ) {
        demandeService.supprimerDemande(id);
    }}
