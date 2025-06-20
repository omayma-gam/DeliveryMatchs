package com.example.deliverymatchs.Services;

import com.example.deliverymatchs.DTO.AnnonceDto;
import com.example.deliverymatchs.DTO.UtilisateursDto;
import com.example.deliverymatchs.Entitys.Annonce;
import com.example.deliverymatchs.Entitys.Utilisateurs;
import com.example.deliverymatchs.Mappers.UtilisateurMapper;
import com.example.deliverymatchs.Repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private UtilisateurMapper utilisateurMapper;
    private final PasswordEncoder passwordEncoder;

    public UtilisateurService(PasswordEncoder passwordEncoder, UtilisateurMapper utilisateurMapper, UtilisateurRepository utilisateurRepository) {
        this.passwordEncoder = passwordEncoder;
        this.utilisateurMapper = utilisateurMapper;
        this.utilisateurRepository = utilisateurRepository;
    }

//    public UtilisateursDto ajouteruser(UtilisateursDto utilisateursDto){
//        Utilisateurs utilisateurs= utilisateurMapper.dtoToUser(utilisateursDto);
//        Utilisateurs utilisateurs1=utilisateurRepository.save(utilisateurs);
//        return utilisateurMapper.userToDto(utilisateurs1);
//    }

    public List<UtilisateursDto> listeUtilisateur() {
        return utilisateurRepository.findAll().stream()
                .map(utilisateurMapper::userToDto)
                .collect(Collectors.toList());
    }

    public UtilisateursDto modifierUser(Long id , UtilisateursDto utilisateursDto){
        Utilisateurs user=utilisateurRepository.findById(id).orElse(null);

        if(user==null){
            throw new RuntimeException("user not found");
        }
        user.setName(utilisateursDto.getName());
        user.setEmail(utilisateursDto.getEmail());
        user.setPassword(passwordEncoder.encode(utilisateursDto.getPassword()));

        return utilisateurMapper.userToDto(user);
    }

    public void supprimerUser(Long id){
        utilisateurRepository.deleteById(id);
    }
}
