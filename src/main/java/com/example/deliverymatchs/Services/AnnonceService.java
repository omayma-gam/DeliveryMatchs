package com.example.deliverymatchs.Services;

import com.example.deliverymatchs.DTO.AnnonceDto;
import com.example.deliverymatchs.Entitys.Annonce;
import com.example.deliverymatchs.Mappers.AnnonceMapper;
import com.example.deliverymatchs.Repositories.AnnonceRepository;
import com.example.deliverymatchs.Repositories.UtilisateurRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnonceService {



    private final AnnonceRepository annonceRepository;
    private AnnonceMapper annonceMapper;
    private UtilisateurRepository utilisateurRepository;

    public AnnonceService(AnnonceRepository annonceRepository, AnnonceMapper annonceMapper) {
        this.annonceRepository = annonceRepository;
        this.annonceMapper = annonceMapper;
    }


    public AnnonceDto AjouterAnnonce(AnnonceDto annonceDto){
        Annonce annonce=annonceMapper.dtoToAnnonce(annonceDto);
        Annonce annonce1=annonceRepository.save(annonce);
        return annonceMapper.annonceToDto(annonce1);
    }
    public List<AnnonceDto> listeAnnonce() {
        return annonceRepository.findAll().stream()
                .map(annonceMapper::annonceToDto)
                .collect(Collectors.toList());
    }

    public AnnonceDto modifierAnnonce(Long id , AnnonceDto annonceDto){
        Annonce annonce=(Annonce) annonceRepository.findById(id).get();
        annonce.setLieu(annonceDto.getLieu());
        annonce.setEtaps(annonceDto.getEtaps());
        annonce.setDestination(annonceDto.getDestination());
        annonce.setDemensionMax(annonceDto.getDemensionMax());
        annonce.setCapaciteDisponible(annonceDto.getCapaciteDisponible());
        annonce.setDate(annonceDto.getDate());
        return annonceMapper.annonceToDto(annonceRepository.save(annonce));


    }

    public void supprimerAnnonce(Long id){
        annonceRepository.deleteById(id);
    }

}
