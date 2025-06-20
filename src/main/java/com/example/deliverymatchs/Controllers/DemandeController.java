package com.example.deliverymatchs.Controllers;

import com.example.deliverymatchs.DTO.DemandeDto;
import com.example.deliverymatchs.Services.DemandeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Demande")
public class DemandeController {

    private final DemandeService demandeService;

    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }


    @PostMapping("/{expediteurId}")
    public ResponseEntity<DemandeDto>  addDemande(@RequestBody DemandeDto demandeDto,@PathVariable Long expediteurId) {
        DemandeDto ajouter =demandeService.AjouterDemande(demandeDto,expediteurId);
        return new ResponseEntity<>(ajouter, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DemandeDto>> ListDemande(){
        return ResponseEntity.ok(demandeService.listeDemande());
    }
    @GetMapping("/{id}")
    public  ResponseEntity<DemandeDto> getDemandeById(@PathVariable Long id){
        return  ResponseEntity.ok(demandeService.ObtenirParid(id));
    }
    @GetMapping("/expediteur/{id}")
    public  ResponseEntity<List<DemandeDto>> AfficherDemandesByExpediteur(@PathVariable Long id){
        return ResponseEntity.ok(demandeService.ObtenirExpediteurparId(id));
    }

//    @PutMapping("/{id}")
//    public DemandeDto updatUser(@PathVariable Long id , @RequestBody DemandeDto annonceDto) {
//        return demandeService.modifierDemande(id,annonceDto);
//    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id ) {
        demandeService.supprimerDemande(id);
    }
    @PostMapping("/{demandeId}/annonce/{annonceId}")
    public ResponseEntity<DemandeDto> assignerAnnonce(@PathVariable Long demandeId,@PathVariable Long annonceId){
        DemandeDto demandeDto = demandeService.AssignerAnnonce(demandeId,annonceId);
        return ResponseEntity.ok(demandeDto);
    }
    @GetMapping("/annonce/{annonceId}")
    public ResponseEntity<List<DemandeDto>> AfficherDeamndeParAnnonce(@PathVariable Long annonceId){
        return ResponseEntity.ok(demandeService.OptenirParAnnonce(annonceId));
    }
}
