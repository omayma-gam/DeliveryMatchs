package com.example.deliverymatchs.Services;

import com.example.deliverymatchs.DTO.AnnonceDto;
import com.example.deliverymatchs.Entitys.Annonce;
import com.example.deliverymatchs.Entitys.Conducteur;
import com.example.deliverymatchs.Mappers.AnnonceMapper;
import com.example.deliverymatchs.Repositories.AnnonceRepository;
import com.example.deliverymatchs.Repositories.UtilisateurRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnonceService {



    private final AnnonceRepository annonceRepository;
    private AnnonceMapper annonceMapper;
    private UtilisateurRepository utilisateurRepository;


    public AnnonceService(AnnonceRepository annonceRepository, AnnonceMapper annonceMapper, UtilisateurRepository utilisateurRepository) {
        this.annonceRepository = annonceRepository;
        this.annonceMapper = annonceMapper;
        this.utilisateurRepository = utilisateurRepository;
    }

    public AnnonceDto AjouterAnnonce(AnnonceDto annonceDto) {
        Annonce annonce = annonceMapper.dtoToAnnonce(annonceDto);

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        Object user = utilisateurRepository.findByEmail(email);

        if (user instanceof Conducteur) {
            Conducteur conducteur = (Conducteur) user;
            annonce.setConducteur(conducteur);
        } else {
            throw new RuntimeException("L'utilisateur connecté n'est pas un conducteur");
        }

        Annonce saved = annonceRepository.save(annonce);
        return annonceMapper.annonceToDto(saved);
    }


    //    public TrajetDto ajouterAnnonce(TrajetDto dto){
//        Trajet trip = trajetMap.toEntity(dto);
//
//        String email = SecurityContextHolder.getContext().getAuthentication().getName();
//        Driver driver = (Driver) userRepository.findByEmail(email);
//
//        trip.setDriver(driver);
//
//        Trajet savedTrip = trajetRepository.save(trip);
//        return trajetMap.toDTO(savedTrip);
//    }
    public List<AnnonceDto> listeAnnonce() {
        return annonceRepository.findAll().stream()
                .map(annonceMapper::annonceToDto)
                .collect(Collectors.toList());
    }
    public List<AnnonceDto> getAnnoncesByConducteurId(Long conducteurId) {
        return annonceRepository.findByConducteurId(conducteurId)
                .stream()
                .map(annonceMapper::annonceToDto)
                .collect(Collectors.toList());
    }
//    public AnnonceDto modifierAnnonce(Long id , AnnonceDto annonceDto){
//        Annonce annonce=(Annonce) annonceRepository.findById(id).get();
//        annonce.setLieu(annonceDto.getLieu());
//        annonce.setEtaps(annonceDto.getEtaps());
//        annonce.setDestination(annonceDto.getDestination());
//        annonce.setDemensionMax(annonceDto.getDemensionMax());
//        annonce.setCapaciteDisponible(annonceDto.getCapaciteDisponible());
//        annonce.setDate(annonceDto.getDate());
//        return annonceMapper.annonceToDto(annonceRepository.save(annonce));
//    }
public AnnonceDto getAnnonceById(Long id) {
    Annonce annonce = annonceRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Annonce non trouvée"));
    return annonceMapper.annonceToDto(annonce);
}

    public void supprimerAnnonce(Long id){
        annonceRepository.deleteById(id);
    }

}
