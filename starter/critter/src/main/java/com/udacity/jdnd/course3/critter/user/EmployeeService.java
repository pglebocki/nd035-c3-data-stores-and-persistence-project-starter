package com.udacity.jdnd.course3.critter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElseGet(null);
    }

    public List<Employee> getEmployeeByService(Set<EmployeeSkill> skills, LocalDate date) {
        List<Employee> employees = employeeRepository.findAll();
        return employees
                .stream()
                .filter(it -> it.getSkills().containsAll(skills))
                .filter(it -> it.getDaysAvailable().contains(date.getDayOfWeek()))
                .collect(Collectors.toList());
    }
}
