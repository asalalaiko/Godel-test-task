package by.asalalaiko.godeltask;

import by.asalalaiko.godeltask.dao.EmployeeDao;
import by.asalalaiko.godeltask.dto.Employee;
import by.asalalaiko.godeltask.dto.Gender;
import by.asalalaiko.godeltask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Date;

@SpringBootApplication
public class GodeltaskApplication {

	@Autowired
	EmployeeService employeeService;

	public static main(String[] args) {
		SpringApplication.run(GodeltaskApplication.class, args);

	Employee employee = new Employee(10L, "Peter", "Petrov", 8L, "manager", Gender.MALE, Date.valueOf("1955-01-21"));

		employeeService.createEmployee(employee);

        System.out.println("Employee record inserted successfully.");}
}
