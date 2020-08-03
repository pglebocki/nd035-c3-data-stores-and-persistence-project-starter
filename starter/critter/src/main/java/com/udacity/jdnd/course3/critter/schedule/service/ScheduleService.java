package com.udacity.jdnd.course3.critter.schedule.service;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.schedule.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getSchedulesByEmployeId(Long employeId) {
        return scheduleRepository.findAll()
                .stream()
                .filter(it -> it.getEmployeeIds().contains(employeId))
                .collect(Collectors.toList());
    }

    public List<Schedule> getSchedulesByPetId(Long petId) {
        return scheduleRepository.findAll()
                .stream()
                .filter(it -> it.getPetIds().contains(petId) )
                .collect(Collectors.toList());
    }

    public List<Schedule> getSchedulesByPetIds(List<Pet> pets) {
        List<Long> petIds = pets.stream()
                .map(Pet::getId)
                .collect(Collectors.toList());

        return scheduleRepository.findAll()
                .stream()
                .filter(it -> it.getPetIds().containsAll(petIds) )
                .collect(Collectors.toList());
    }
}
