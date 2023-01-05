package net.dmly.apiapplication.repository.impl;

import lombok.RequiredArgsConstructor;
import net.dmly.apiapplication.model.Employee;
import net.dmly.apiapplication.repository.EmployeeRepository;
import net.dmly.apiapplication.repository.JpaEmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaEmployeeRepositoryAdapter implements EmployeeRepository {

    private final JpaEmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository
                .findById(id)
                .orElseThrow();
    }

    @Override
    public Employee updateEmployee(Employee modifiedEmployee) {
        return employeeRepository.save(modifiedEmployee);
    }

    @Override
    public Boolean deleteById(Long id) {
        employeeRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
