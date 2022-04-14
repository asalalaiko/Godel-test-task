package by.asalalaiko.godeltask;

import by.asalalaiko.godeltask.dto.Employee;
import by.asalalaiko.godeltask.dto.Gender;
import by.asalalaiko.godeltask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;

@SpringBootApplication
public class GodeltaskApplication {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(GodeltaskApplication.class, args);
		EmployeeService employeeService = context.getBean(EmployeeService.class);


		Employee employee = new Employee();
		employee.setFirstName("Peter");
		employee.setLastName("Petrov");
		employee.setDepartmentId(8L);
		employee.setJobTitle("manager");
		employee.setGender(Gender.MALE.toString());
		employee.setDataOfBirth(Date.valueOf("1955-01-21"));



		employeeService.createEmployee(employee);

        System.out.println("Employee record inserted successfully."+employee.toString());

        System.out.println("List:");
		employeeService.findAllEmployees().stream().forEach(s -> System.out.println(s.toString()));

		employeeService.deleteEmployeeById(6L);

		System.out.println("List:");
		employeeService.findAllEmployees().stream().forEach(s -> System.out.println(s.toString()));


	}


}
