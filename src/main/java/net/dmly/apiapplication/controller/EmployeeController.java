package net.dmly.apiapplication.controller;

import lombok.RequiredArgsConstructor;
import net.dmly.apiapplication.model.Employee;
import net.dmly.apiapplication.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static net.dmly.apiapplication.utils.ControllerUtils.getLocation;

@RestController
@RequestMapping(path = "/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee addedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.created(getLocation(addedEmployee.getId())).body(addedEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.deleteById(id));
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }

}
