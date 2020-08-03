package com.udacity.jdnd.course3.critter.schedule.service;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import com.udacity.jdnd.course3.critter.schedule.entity.Schedule;
import com.udacity.jdnd.course3.critter.schedule.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> getSchedulesByEmployeeId(Long employeId) {
        return scheduleRepository.findAll()
                .stream()
                .filter(it -> getEmployeesIds(it.getEmployees()).contains(employeId))
                .collect(Collectors.toList());
    }

    public List<Schedule> getSchedulesByPetId(Long petId) {
        return scheduleRepository.findAll()
                .stream()
                .filter(it -> getPetsIds(it.getPets()).contains(petId))
                .collect(Collectors.toList());
    }

    public List<Schedule> getSchedulesByPetIds(List<Pet> pets) {
        List<Long> petIds = pets.stream()
                .map(Pet::getId)
                .collect(Collectors.toList());

        return scheduleRepository.findAll()
                .stream()
                .filter(it -> getPetsIds(it.getPets()).containsAll(petIds))
                .collect(Collectors.toList());
    }

    private List<Long> getEmployeesIds(List<Employee> employees) {
        return employees
                .stream()
                .map(Employee::getId)
                .collect(Collectors.toList());
    }

    private List<Long> getPetsIds(List<Pet> employees) {
        return employees
                .stream()
                .map(Pet::getId)
                .collect(Collectors.toList());
    }
}
