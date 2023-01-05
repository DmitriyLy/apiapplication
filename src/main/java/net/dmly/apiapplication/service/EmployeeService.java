package net.dmly.apiapplication.service;

import net.dmly.apiapplication.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee findById(Long id);

    Employee updateEmployee(Employee employee);

    Boolean deleteById(Long id);
}
