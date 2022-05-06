package by.asalalaiko.godeltask.dao;

import by.asalalaiko.godeltask.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

    @Autowired
    DataSource dataSource;
    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }


    public static final String INSERT_STATEMENT = "INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth) VALUES (?,?,?,?,?,?)";
    public static final String UPDATE_STATEMENT = "UPDATE employee SET first_name=?, last_name=?, department_id=?, job_title=?, gender=?, date_of_birth=? WHERE employee_id = ?";
    public static final String DELETE_STATEMENT = "DELETE FROM employee WHERE employee_id = ?";
    public static final String SELECT_STATEMENT = "SELECT * FROM employee";
    public static final String SELECT_BY_ID_SQL = "SELECT * FROM employee WHERE employee_id = ?";



    @Override
    public Employee createEmployee(Employee employee) {
                getJdbcTemplate().update(INSERT_STATEMENT, new Object[] {
                        employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                        employee.getJobTitle(), employee.getGender().toString(), employee.getDateOfBirth()
        });
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        getJdbcTemplate().update(UPDATE_STATEMENT, new Object[] {
                employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(),
                employee.getJobTitle(), employee.getGender().toString(), employee.getDateOfBirth(),
                employee.getEmployeeId()
        });
        return employee;
    }

    @Override
    public void deleteEmployeeById(Long empId) {
        getJdbcTemplate().update(DELETE_STATEMENT, new Object[]{empId});
    }

    @Override
    public Employee findEmployeeById(Long empId) {
        Employee emp = new Employee();
        emp = (Employee) getJdbcTemplate().query(SELECT_BY_ID_SQL, new Object[]{empId}, new BeanPropertyRowMapper(Employee.class))
                .stream().findAny().orElse(null);
        return emp;
    }

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> empList = new ArrayList<Employee>();
        empList = getJdbcTemplate().query(SELECT_STATEMENT, new BeanPropertyRowMapper(Employee.class));

        return empList;
    }
}
