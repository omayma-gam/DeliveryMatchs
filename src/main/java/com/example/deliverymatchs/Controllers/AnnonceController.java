package com.example.deliverymatchs.Controllers;

import com.example.deliverymatchs.DTO.AnnonceDto;
import com.example.deliverymatchs.Services.AnnonceService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <AnnonceDto> addAnnonce(@RequestBody AnnonceDto annonceDto){
        AnnonceDto creat = annonceService.AjouterAnnonce(annonceDto);
        return ResponseEntity.ok(creat);
    }
    @GetMapping
    public ResponseEntity<List<AnnonceDto>> getAllAnnonce(){
        List<AnnonceDto> list=annonceService.listeAnnonce();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/conducteur/{conducteurId}")
    public ResponseEntity<List<AnnonceDto>>getAnnonceByConducteurId(@PathVariable Long conducteurId){
        List<AnnonceDto>list=annonceService.getAnnoncesByConducteurId(conducteurId);
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AnnonceDto> getAnnonceById(@PathVariable Long id) {
        AnnonceDto annonce = annonceService.getAnnonceById(id);
        return ResponseEntity.ok(annonce);
    }
//    @PutMapping("/{id}")
//    public AnnonceDto updatAnnonce(@PathVariable Long id ,@RequestBody AnnonceDto annonceDto) {
//        return annonceService.modifierAnnonce(id,annonceDto);
//    }
    @DeleteMapping("/{id}")
    public void deleteAnnonce(@PathVariable Long id )
    {
        annonceService.supprimerAnnonce(id);
    }
}
