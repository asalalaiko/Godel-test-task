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
    List<Employee> findAll() {
        return employeeService.findAllEmployees();
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeService.saveEmployee(newEmployee);
    }


    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {

        return employeeService.findEmployeeById(id);
    }

    @PutMapping("/employees")
    Employee replaceEmployee(@RequestBody Employee newEmployee) {

        return employeeService.saveEmployee(newEmployee);

    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
    }
}
