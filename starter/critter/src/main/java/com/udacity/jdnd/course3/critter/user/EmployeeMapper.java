package com.udacity.jdnd.course3.critter.user;

import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee DTOtoEntity(EmployeeDTO dto) {
        Employee entity = new Employee();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSkills(dto.getSkills());
        return entity;
    }

    public EmployeeDTO entityToDTO(Employee entity) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSkills(entity.getSkills());
        return dto;
    }
}
