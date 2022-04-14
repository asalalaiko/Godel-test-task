package by.asalalaiko.godeltask.service;

import by.asalalaiko.godeltask.dao.EmployeeDao;
import by.asalalaiko.godeltask.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeDao employeeDao;


    public void createEmployee(Employee employee){

        employeeDao.createEmployee(employee);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployeeById(Long empId) {
        employeeDao.deleteEmployeeById(empId);
    }

    @Override
    public Employee findEmployeeById(Long empId) {
        return employeeDao.findEmployeeById(empId);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }


}
