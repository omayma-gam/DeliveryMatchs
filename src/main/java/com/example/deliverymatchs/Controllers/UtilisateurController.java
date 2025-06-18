package com.example.deliverymatchs.Controllers;

import com.example.deliverymatchs.DTO.UtilisateursDto;
import com.example.deliverymatchs.Services.UtilisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UtilisateurController {


    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }


    @PostMapping("/add")
    public UtilisateursDto addUser(@RequestBody UtilisateursDto utilisateursDto){
        return utilisateurService.ajouteruser(utilisateursDto);
    }
    @GetMapping
    public List<UtilisateursDto> getAllUser(){
        return utilisateurService.listeUtilisateur();
    }
    @PutMapping("/{id}")
    public UtilisateursDto updatUser(@PathVariable Long id , @RequestBody UtilisateursDto annonceDto) {
        return utilisateurService.modifierUser(id,annonceDto);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id ) {
        utilisateurService.supprimerUser(id);
    }
}
