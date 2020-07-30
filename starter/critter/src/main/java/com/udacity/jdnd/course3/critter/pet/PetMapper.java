package com.udacity.jdnd.course3.critter.pet;

import com.udacity.jdnd.course3.critter.user.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetMapper {

    public Pet DTOtoEntity(PetDTO dto, Customer customer) {
        Pet entity = new Pet();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setNotes(dto.getNotes());
        entity.setType(dto.getType());
        entity.setBirthDate(dto.getBirthDate());
//        entity.setCustomer(customer);
        return entity;
    }

    public PetDTO entityToDTO(Pet entity) {
        PetDTO dto = new PetDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setNotes(entity.getNotes());
        dto.setType(entity.getType());
        dto.setBirthDate(entity.getBirthDate());
//        dto.setOwnerId(entity.getCustomer().getId());
        return dto;
    }

    public List<PetDTO> entitiesToDTOs(List<Pet> entities) {
        return entities
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
}
