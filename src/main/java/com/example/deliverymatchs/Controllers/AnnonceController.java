package com.example.deliverymatchs.Controllers;

import com.example.deliverymatchs.DTO.AnnonceDto;
import com.example.deliverymatchs.Services.AnnonceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Annonce")
public class AnnonceController {


    public AnnonceController(AnnonceService annonceService){
        this.annonceService = annonceService;
    }

    private final AnnonceService annonceService;


    @PostMapping("/add")
    public AnnonceDto addAnnonce(@RequestBody AnnonceDto annonceDto){
        return annonceService.AjouterAnnonce(annonceDto);
    }
    @GetMapping
    public List<AnnonceDto> getAllAnnonce(){
        return annonceService.listeAnnonce();
    }
    @PutMapping("/{id}")
    public AnnonceDto updatAnnonce(@PathVariable Long id ,@RequestBody AnnonceDto annonceDto) {
        return annonceService.modifierAnnonce(id,annonceDto);
    }
    @DeleteMapping("/{id}")
    public void deleteAnnonce(@PathVariable Long id ) {
        annonceService.supprimerAnnonce(id);
    }
}
