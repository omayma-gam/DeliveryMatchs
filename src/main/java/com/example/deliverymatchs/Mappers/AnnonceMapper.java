package com.example.deliverymatchs.Mappers;

import com.example.deliverymatchs.DTO.AnnonceDto;
import com.example.deliverymatchs.DTO.UtilisateursDto;
import com.example.deliverymatchs.Entitys.Annonce;
import com.example.deliverymatchs.Entitys.Utilisateurs;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AnnonceMapper {
    AnnonceDto annonceToDto(Annonce annonce);
    Annonce dtoToAnnonce(AnnonceDto annonceDto);

}
