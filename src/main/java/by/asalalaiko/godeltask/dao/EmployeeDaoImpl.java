package by.asalalaiko.godeltask.dao;

import by.asalalaiko.godeltask.dto.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;


public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

    public static final String INSERT_STATEMENT = "INSERT INTO employee VALUES (%s)";
    public static final String UPDATE_STATEMENT = "UPDATE %s SET %s WHERE id = %s";
    public static final String DELETE_STATEMENT = "DELETE FROM employee WHERE id = %d";
    public static final String SELECT_STATEMENT = "SELECT * FROM employee";
    public static final String SELECT_BY_ID_SQL = "SELECT * FROM employee WHERE id = %d";



    @Override
    public void createEmployee(Employee employee) {
                getJdbcTemplate().update(INSERT_STATEMENT, new Object[] {
                        employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                        employee.getJobTitle(), employee.getGender(), employee.getDataOfBirth()
        });
    }

    @Override
    public void saveEmployee(Employee employee) {
        getJdbcTemplate().update(INSERT_STATEMENT, new Object[] { employee.getEmployeeId(),
                employee.getFirstName(), employee.getGender()
        });
    }

    @Override
    public void deleteEmployeeById(Long empId) {

    }

    @Override
    public Employee findEmployeeById(Long empId) {
        Employee emp = null;
        String query = "select * from employee where emp_id=?";
        Object[] inputs = new Object[] {empId};
        emp = (Employee) getJdbcTemplate().queryForObject(query, inputs,
                new BeanPropertyRowMapper(Employee.class));
        return emp;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return null;
    }
}
