package com.example.deliverymatchs.Services;

import com.example.deliverymatchs.DTO.AnnonceDto;
import com.example.deliverymatchs.DTO.DemandeDto;
import com.example.deliverymatchs.Entitys.Annonce;
import com.example.deliverymatchs.Entitys.Demande;
import com.example.deliverymatchs.Entitys.Expediteur;
import com.example.deliverymatchs.Entitys.Utilisateurs;
import com.example.deliverymatchs.Mappers.AnnonceMapper;
import com.example.deliverymatchs.Mappers.DemandeMapper;
import com.example.deliverymatchs.Repositories.AnnonceRepository;
import com.example.deliverymatchs.Repositories.DemandeRepositori;
import com.example.deliverymatchs.Repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class DemandeService {

    private final DemandeRepositori demandeRepository;
    private DemandeMapper demandeMapper;
    private final UtilisateurRepository utilisateurRepository;
    private final AnnonceRepository annonceRepository;

    public DemandeService(UtilisateurRepository utilisateurRepository, AnnonceRepository annonceRepository, DemandeMapper demandeMapper, DemandeRepositori demandeRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.annonceRepository = annonceRepository;
        this.demandeMapper = demandeMapper;
        this.demandeRepository = demandeRepository;
    }

    public DemandeDto AjouterDemande(DemandeDto demandeDto,Long expideteurid){
        Utilisateurs user = utilisateurRepository.findById(expideteurid)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable avec l’ID : " + expideteurid));
        if (!(user instanceof Expediteur)) {
            throw new RuntimeException("L'utilisateur avec l’ID " + expideteurid + " n'est pas un expéditeur");
        }
        Demande demande=demandeMapper.dtoToDemande(demandeDto);
        demande.setDateDemande(new Date());
        demande.setExpediteur((Expediteur) user);
//        Demande demande1=demandeRepository.save(demande);
        return demandeMapper.demandeToDto(demandeRepository.save(demande));
    }
    public List<DemandeDto> listeDemande() {
        return demandeRepository.findAll().stream()
                .map(demandeMapper::demandeToDto)
                .collect(Collectors.toList());
    }
    public DemandeDto ObtenirParid(Long id){
        return demandeRepository.findById(id)
                .map(demandeMapper::demandeToDto)
                .orElseThrow(()-> new RuntimeException("Demande Non trouvé"));
    }
    public  List<DemandeDto> ObtenirExpediteurparId(Long expediteur){
        return demandeRepository.findByExpediteurId(expediteur).stream()
                .map(demandeMapper::demandeToDto).collect(Collectors.toList());
    }
    public DemandeDto AssignerAnnonce(Long demandeId ,Long annonceId){
        Demande demande = demandeRepository.findById(demandeId).orElseThrow(()-> new RuntimeException("Deamnde introuvable"));
        Annonce annonce = annonceRepository.findById(annonceId).orElseThrow(()-> new RuntimeException("Annonce introuvable"));
        demande.setAnnonce(annonce);
        return demandeMapper.demandeToDto(demandeRepository.save(demande));
    }

//    public DemandeDto modifierDemande(Long id , DemandeDto demandeDto){
//            Demande demande=(Demande) demandeRepository.findById(id).get();
//        demande.setStatut(demandeDto.getStatut());
//        demande.setDateDemande(demandeDto.getDateDemande());
//        demande.setType(demandeDto.getType());
//        demande.setPoids(demandeDto.getPoids());
//        return demandeMapper.demandeToDto(demandeRepository.save(demande));
//
//
//    }

    public void supprimerDemande(Long id){
        demandeRepository.deleteById(id);
    }
    public List<DemandeDto> OptenirParAnnonce(Long annonceId){
        return demandeRepository.findByAnnonceId(annonceId).stream()
                .map(demandeMapper::demandeToDto)
                .collect(Collectors.toList());
    }

}
