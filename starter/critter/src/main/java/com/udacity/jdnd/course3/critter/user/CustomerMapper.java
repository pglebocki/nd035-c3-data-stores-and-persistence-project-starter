package com.udacity.jdnd.course3.critter.user;

import com.udacity.jdnd.course3.critter.pet.Pet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Customer DTOtoEntity(CustomerDTO dto, List<Pet> pets) {
        Customer entity = new Customer();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setNotes(dto.getNotes());
        entity.setPets(pets);
        return entity;
    }

    public CustomerDTO entityToDTO(Customer entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setNotes(entity.getNotes());
        dto.setPetIds(getIds(entity.getPets()));
        return dto;
    }

    public List<CustomerDTO> entitiesToDTOs(List<Customer> entities) {
        return entities
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    private List<Long> getIds(List<Pet> pets) {
        return pets
                .stream()
                .map(Pet::getId)
                .collect(Collectors.toList());
    }
}
