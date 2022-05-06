package by.asalalaiko.godeltask.service;

import by.asalalaiko.godeltask.dto.Employee;

import java.util.List;

public interface EmployeeService {
   // public Employee createEmployee(Employee employee);
    public Employee saveEmployee(Employee employee);
    public void deleteEmployeeById(Long empId);
    public Employee findEmployeeById(Long empId);
    public List<Employee> findAllEmployees();
}
