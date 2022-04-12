package by.asalalaiko.godeltask.dao;

import by.asalalaiko.godeltask.dto.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao {

    public void createEmployee(Employee employee);
    public void saveEmployee(Employee employee);
    public void deleteEmployeeById(Long empId);
    public Employee findEmployeeById(Long empId);
    public List<Employee> findAllEmployees();

}
