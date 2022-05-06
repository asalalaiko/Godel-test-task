package by.asalalaiko.godeltask;


import by.asalalaiko.godeltask.dto.Employee;
import by.asalalaiko.godeltask.dto.Gender;
import by.asalalaiko.godeltask.service.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest
class GodeltaskApplicationTests {

	private static final ObjectMapper om = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private EmployeeServiceImpl employeeService;


    @Test
    public void find_employeeId() throws Exception {

        mockMvc.perform(get("/employees/2"))
                /*.andDo(print())*/
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeId", is(2)))
                .andExpect(jsonPath("$.firstName", is("Ann")))
                .andExpect(jsonPath("$.lastName", is("Smitt")))
                .andExpect(jsonPath("$.departmentId", is(14)))
                .andExpect(jsonPath("$.jobTitle", is("engineer")))
                .andExpect(jsonPath("$.gender", is("FEMALE")))
                .andExpect(jsonPath("$.dateOfBirth", is(948574800000L)));

    }

	@Test
	public void save_employee_OK() throws Exception {

		Employee employee = new Employee();
		employee.setFirstName("TestName");
		employee.setLastName("TestLastName");
		employee.setDepartmentId(15L);
		employee.setJobTitle("cleaner");
		employee.setGender(Gender.FEMALE);
		employee.setDateOfBirth(Date.valueOf("1980-04-16"));


		mockMvc.perform(post("/employees")
				.content(om.writeValueAsString(employee))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				/*.andDo(print())*/
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName", is("TestName")))
				.andExpect(jsonPath("$.lastName", is("TestLastName")))
				.andExpect(jsonPath("$.departmentId", is(15)));
	}

	@Test
	public void update_book_OK() throws Exception {

		String responseJsonString  =   mockMvc.perform(get("/employees/4"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		ObjectMapper objectMapper = new ObjectMapper();
		Employee employee = objectMapper.readValue(responseJsonString, Employee.class);

		employee.setFirstName("TestFirstName");

		mockMvc.perform(put("/employees")
				.content(om.writeValueAsString(employee))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName", is("TestFirstName")));
	}

	@Test
	public void delete_book_OK() throws Exception {

		mockMvc.perform(delete("/employees/1")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());


		mockMvc.perform(get("/employees")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andDo(print());
	}




	@Test
	void contextLoads() {
	}

}
