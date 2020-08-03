package com.udacity.jdnd.course3.critter.pet.mapper;

import com.udacity.jdnd.course3.critter.pet.dto.PetDTO;
import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetMapper {

    public Pet DTOtoEntity(PetDTO dto) {
        Pet entity = new Pet();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setNotes(dto.getNotes());
        entity.setType(dto.getType());
        entity.setBirthDate(dto.getBirthDate());
        return entity;
    }

    public PetDTO entityToDTO(Pet entity) {
        PetDTO dto = new PetDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setNotes(entity.getNotes());
        dto.setType(entity.getType());
        dto.setBirthDate(entity.getBirthDate());
        if (entity.getCustomer() != null) {
            dto.setOwnerId(entity.getCustomer().getId());
        }
        return dto;
    }

    public List<PetDTO> entitiesToDTOs(List<Pet> entities) {
        return entities
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
}
