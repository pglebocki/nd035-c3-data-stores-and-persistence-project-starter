package com.udacity.jdnd.course3.critter.schedule.mapper;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.schedule.dto.ScheduleDTO;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduleMapper {

    public Schedule DTOtoEntity(ScheduleDTO dto) {
        Schedule entity = new Schedule();
        entity.setActivities(dto.getActivities());
        entity.setDate(dto.getDate());
        return entity;
    }

    public ScheduleDTO entityToDTO(Schedule entity) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setActivities(entity.getActivities());
        dto.setDate(entity.getDate());
        dto.setEmployeeIds(entity.getEmployees().stream().map(Employee::getId).collect(Collectors.toList()));
        dto.setPetIds(entity.getPets().stream().map(Pet::getId).collect(Collectors.toList()));
        return dto;
    }

    public List<ScheduleDTO> entitiesToDTOs(List<Schedule> entities) {
        return entities
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
}
