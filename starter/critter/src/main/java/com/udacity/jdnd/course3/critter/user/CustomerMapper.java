package com.udacity.jdnd.course3.critter.user;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public Customer DTOtoEntity(CustomerDTO dto) {
        Customer entity = new Customer();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setNotes(dto.getNotes());
        //entity.setPetIds(dto.getPetIds());
        return entity;
    }

    public CustomerDTO entityToDTO(Customer entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setNotes(entity.getNotes());
        //dto.setPetIds(entity.getPetIds());
        return dto;
    }

    public List<CustomerDTO> entitiesToDTOs(List<Customer> entities) {
        return entities
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
}
