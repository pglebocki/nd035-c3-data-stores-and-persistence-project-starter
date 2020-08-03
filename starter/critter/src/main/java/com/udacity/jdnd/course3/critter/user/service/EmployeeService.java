package com.udacity.jdnd.course3.critter.user.service;

import com.udacity.jdnd.course3.critter.user.dto.EmployeeSkill;
import com.udacity.jdnd.course3.critter.user.entity.Employee;
import com.udacity.jdnd.course3.critter.user.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }



    public Employee getEmployee(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    public List<Employee> getEmployeesByIds(List<Long> ids) {
        List<Employee> employees = new ArrayList<>();
        if (ids != null) {
            for (Long id : ids) {
                Optional<Employee> employeeOptional = employeeRepository.findById(id);
                employeeOptional.ifPresent(employees::add);
            }
        }
        return employees;
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
