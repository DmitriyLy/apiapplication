package net.dmly.apiapplication.repository;

import net.dmly.apiapplication.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryEmployeeRepository {
    private static List<Employee> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new Employee(1L, "John", "Smith", "john@gmail.com"));
        DATABASE.add(new Employee(2L, "Alex", "Total", "alext@gmail.com"));
        DATABASE.add(new Employee(2L, "David", "Notus", "davidn@gmail.com"));
    }

    void addEmployee(Employee employee){
        DATABASE.add(employee);
    }

    List<Employee> getAllEmployees(){
        return List.copyOf(DATABASE);
    }

    Employee findById(Long id){
        return DATABASE.stream()
                .filter(employee -> id.equals(employee.getId()))
                .findFirst()
                .orElseThrow();
    }

    void updateEmployee(Employee modifiedEmployee){
        Employee existingEmployee = findById(modifiedEmployee.getId());

        DATABASE.remove(existingEmployee);
        DATABASE.add(modifiedEmployee);

    }

    Boolean deleteById(Long id){
        DATABASE.remove(findById(id));
        return Boolean.TRUE;
    }
}
