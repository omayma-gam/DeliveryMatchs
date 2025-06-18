package com.example.deliverymatchs.Mappers;

import com.example.deliverymatchs.DTO.AnnonceDto;
import com.example.deliverymatchs.DTO.DemandeDto;
import com.example.deliverymatchs.Entitys.Annonce;
import com.example.deliverymatchs.Entitys.Demande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface DemandeMapper {
    DemandeDto demandeToDto(Demande demande);

    @Mapping(target = "annonce", ignore = true)
    @Mapping(target = "expediteur", ignore = true)
    Demande dtoToDemande(DemandeDto demandeDto);

}
