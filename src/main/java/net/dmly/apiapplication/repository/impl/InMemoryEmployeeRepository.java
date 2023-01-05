package net.dmly.apiapplication.repository.impl;

import net.dmly.apiapplication.model.Employee;
import net.dmly.apiapplication.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository {
    private static List<Employee> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new Employee(1L, "John", "Smith", "john@gmail.com"));
        DATABASE.add(new Employee(2L, "Alex", "Total", "alext@gmail.com"));
        DATABASE.add(new Employee(2L, "David", "Notus", "davidn@gmail.com"));
    }

    @Override
    public void addEmployee(Employee employee){
        DATABASE.add(employee);
    }

    @Override
    public List<Employee> getAllEmployees(){
        return List.copyOf(DATABASE);
    }

    @Override
    public Employee findById(Long id){
        return DATABASE.stream()
                .filter(employee -> id.equals(employee.getId()))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public void updateEmployee(Employee modifiedEmployee){
        Employee existingEmployee = findById(modifiedEmployee.getId());

        DATABASE.remove(existingEmployee);
        DATABASE.add(modifiedEmployee);

    }

    @Override
    public Boolean deleteById(Long id){
        DATABASE.remove(findById(id));
        return Boolean.TRUE;
    }
}
