package net.dmly.apiapplication.repository;

import net.dmly.apiapplication.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee findById(Long id);

    void updateEmployee(Employee modifiedEmployee);

    Boolean deleteById(Long id);
}
