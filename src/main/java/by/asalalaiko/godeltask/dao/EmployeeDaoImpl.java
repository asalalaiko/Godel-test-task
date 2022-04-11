package by.asalalaiko.godeltask.dao;

import by.asalalaiko.godeltask.dto.Employee;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {
    @Override
    public void createEmployee(Employee employee) {
        
    }

    @Override
    public void saveEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployeeById(Long empId) {

    }

    @Override
    public Employee findEmployeeById(Long empId) {
        return null;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return null;
    }
}
