package com.example.deliverymatchs.Services;

import com.example.deliverymatchs.DTO.AnnonceDto;
import com.example.deliverymatchs.DTO.UtilisateursDto;
import com.example.deliverymatchs.Entitys.Annonce;
import com.example.deliverymatchs.Entitys.Utilisateurs;
import com.example.deliverymatchs.Mappers.UtilisateurMapper;
import com.example.deliverymatchs.Repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private UtilisateurMapper utilisateurMapper;

    public UtilisateurService(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
    }

    public UtilisateursDto ajouteruser(UtilisateursDto utilisateursDto){
        Utilisateurs utilisateurs= utilisateurMapper.dtoToUser(utilisateursDto);
        Utilisateurs utilisateurs1=utilisateurRepository.save(utilisateurs);
        return utilisateurMapper.userToDto(utilisateurs1);
    }

    public List<UtilisateursDto> listeUtilisateur() {
        return utilisateurRepository.findAll().stream()
                .map(utilisateurMapper::userToDto)
                .collect(Collectors.toList());
    }

    public UtilisateursDto modifierUser(Long id , UtilisateursDto utilisateursDto){
        Utilisateurs user=(Utilisateurs) utilisateurRepository.findById(id).get();
       user.setName(utilisateursDto.getName());
        user.setEmail(utilisateursDto.getEmail());
        user.setRole(utilisateursDto.getRole());
        return utilisateurMapper.userToDto(utilisateurRepository.save(user));
    }

    public void supprimerUser(Long id){
        utilisateurRepository.deleteById(id);
    }
}
