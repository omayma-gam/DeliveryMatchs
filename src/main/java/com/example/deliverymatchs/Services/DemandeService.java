package com.example.deliverymatchs.Services;

import com.example.deliverymatchs.DTO.AnnonceDto;
import com.example.deliverymatchs.DTO.DemandeDto;
import com.example.deliverymatchs.Entitys.Annonce;
import com.example.deliverymatchs.Entitys.Demande;
import com.example.deliverymatchs.Mappers.AnnonceMapper;
import com.example.deliverymatchs.Mappers.DemandeMapper;
import com.example.deliverymatchs.Repositories.AnnonceRepository;
import com.example.deliverymatchs.Repositories.DemandeRepositori;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DemandeService {

    private final DemandeRepositori demandeRepository;
    private DemandeMapper demandeMapper;

    public DemandeService(DemandeRepositori demandeRepository, DemandeMapper demandeMapper) {
        this.demandeRepository = demandeRepository;
        this.demandeMapper = demandeMapper;
    }

    public DemandeDto AjouterDemande(DemandeDto demandeDto){
        Demande demande=demandeMapper.dtoToDemande(demandeDto);
        Demande demande1=demandeRepository.save(demande);
        return demandeMapper.demandeToDto(demande1);
    }
    public List<DemandeDto> listeDemande() {
        return demandeRepository.findAll().stream()
                .map(demandeMapper::demandeToDto)
                .collect(Collectors.toList());
    }

    public DemandeDto modifierDemande(Long id , DemandeDto demandeDto){
            Demande demande=(Demande) demandeRepository.findById(id).get();
        demande.setStatut(demandeDto.getStatut());
        demande.setDateDemande(demandeDto.getDateDemande());
        demande.setType(demandeDto.getType());
        demande.setPoids(demandeDto.getPoids());
        return demandeMapper.demandeToDto(demandeRepository.save(demande));


    }

    public void supprimerDemande(Long id){
        demandeRepository.deleteById(id);
    }

}
