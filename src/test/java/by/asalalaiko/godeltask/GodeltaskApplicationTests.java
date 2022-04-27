package by.asalalaiko.godeltask;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

	@Before
	public void init() throws ParseException {

	}

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
	void contextLoads() {
	}

}
