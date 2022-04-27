package by.asalalaiko.godeltask;

import by.asalalaiko.godeltask.dto.Employee;
import by.asalalaiko.godeltask.dto.Gender;
import by.asalalaiko.godeltask.service.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest
class GodeltaskApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private EmployeeServiceImpl employeeService;



	@Before
	public void init() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		employeeService.createEmployee(new Employee(1L,"Ivan","Ivanov", 10L,"manger", Gender.MALE, (Date) formatter.parse("1985-05-05")));
		employeeService.createEmployee(new Employee(2L,"Ira","Ivanova", 10L,"manger", Gender.FEMALE, (Date) formatter.parse("1996-02-25")));
		employeeService.createEmployee(new Employee(3L,"Sasha","Ivanov", 10L,"manger", Gender.MALE, (Date) formatter.parse("1988-05-15")));
		employeeService.createEmployee(new Employee(4L,"Oleg","Olegov", 10L,"manger", Gender.MALE, (Date) formatter.parse("2000-12-30")));
		employeeService.createEmployee(new Employee(5L,"Nataly","Ivanova", 10L,"manger", Gender.FEMALE, (Date) formatter.parse("1999-01-15")));
	}

    @Test
    public void find_employeeId() throws Exception {

        mockMvc.perform(get("/employees/2"))
                /*.andDo(print())*/
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstName", is("Ivan")))
                .andExpect(jsonPath("$.lastName", is("Ivanov")))
                .andExpect(jsonPath("$.departmentId", is("Ivanov")))
                .andExpect(jsonPath("$.jobTitle", is("Ivanov")))
                .andExpect(jsonPath("$.gender", is("Ivanov")))
                .andExpect(jsonPath("$.dateOfBirth", is(9.99)));

        verify(employeeService, times(1)).findEmployeeById(1L);

    }


	@Test
	void contextLoads() {
	}

}
