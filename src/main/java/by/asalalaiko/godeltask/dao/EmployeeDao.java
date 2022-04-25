package by.asalalaiko.godeltask.dao;

import by.asalalaiko.godeltask.dto.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeDao {

    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployeeById(Long empId);
    public Employee findEmployeeById(Long empId);
    public List<Employee> findAllEmployees();

}
