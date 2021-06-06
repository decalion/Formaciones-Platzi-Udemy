package com.icaballero.arquitecturahexagonal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.icaballero.arquitecturahexagonal.adapters.secundary.CourseRepositoryImpl;
import com.icaballero.arquitecturahexagonal.domain.Course;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class IntegrationTest {
	
	
	private CourseRepositoryImpl sut = new CourseRepositoryImpl();

	@Autowired
	public MockMvc mockMvc;
	
	@Before
	public void setUp() {
		sut.addCourse(new Course("Curso 1", 60));
		sut.addCourse(new Course("Curso 2", 40));
		sut.addCourse(new Course("Curso 3", 20));
		
	}
	
	
	@Test
	public void shouldGetAllCourses() throws Exception {
		mockMvc.perform(get("/courses")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		
	}

	
	

	
	
}
