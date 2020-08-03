package com.udacity.jdnd.course3.critter.user.mapper;

import com.udacity.jdnd.course3.critter.user.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public Employee DTOtoEntity(EmployeeDTO dto) {
        Employee entity = new Employee();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSkills(dto.getSkills());
        entity.setDaysAvailable(dto.getDaysAvailable());
        return entity;
    }

    public EmployeeDTO entityToDTO(Employee entity) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSkills(entity.getSkills());
        dto.setDaysAvailable(entity.getDaysAvailable());
        return dto;
    }

    public List<EmployeeDTO> entitiesToDTOs(List<Employee> entities) {
        return entities
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
}
