package by.asalalaiko.godeltask.rest;


import by.asalalaiko.godeltask.dto.Employee;
import by.asalalaiko.godeltask.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAllEmployees();
    }

    @PostMapping("/employees")
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeService.saveEmployee(newEmployee);
    }


    @GetMapping("/employees/{id}")
    public Employee one(@PathVariable Long id) {

        return employeeService.findEmployeeById(id);
    }

    @PutMapping("/employees")
    public Employee replaceEmployee(@RequestBody Employee newEmployee) {

        return employeeService.saveEmployee(newEmployee);

    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }
}
