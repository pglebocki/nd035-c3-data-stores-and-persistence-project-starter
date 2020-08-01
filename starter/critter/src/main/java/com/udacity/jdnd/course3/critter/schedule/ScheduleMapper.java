package com.udacity.jdnd.course3.critter.schedule;

import org.assertj.core.util.Lists;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScheduleMapper {

    public Schedule DTOtoEntity(ScheduleDTO dto) {
        Schedule entity = new Schedule();
        entity.setActivities(dto.getActivities());
        entity.setDate(dto.getDate());
        entity.setEmployeeIds(dto.getEmployeeIds());
        entity.setPetIds(dto.getPetIds());
        return entity;
    }

    public ScheduleDTO entityToDTO(Schedule entity) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setActivities(entity.getActivities());
        dto.setDate(entity.getDate());
        dto.setEmployeeIds(Lists.newArrayList(entity.getEmployeeIds()));
        dto.setPetIds(Lists.newArrayList(entity.getPetIds()));
        return dto;
    }

    public List<ScheduleDTO> entitiesToDTOs(List<Schedule> entities) {
        return entities
                .stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
}
