package by.asalalaiko.godeltask.service;

import by.asalalaiko.godeltask.dao.EmployeeDao;
import by.asalalaiko.godeltask.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;


    public void createEmployee(Employee employee){
        employeeDao.createEmployee(employee);
    }


}
