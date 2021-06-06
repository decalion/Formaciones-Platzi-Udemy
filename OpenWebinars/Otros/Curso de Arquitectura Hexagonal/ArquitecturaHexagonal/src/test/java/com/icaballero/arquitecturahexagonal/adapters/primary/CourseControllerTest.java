package com.icaballero.arquitecturahexagonal.adapters.primary;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.icaballero.arquitecturahexagonal.domain.Course;
import com.icaballero.arquitecturahexagonal.ports.primary.CourseService;


public class CourseControllerTest {
	
	
	public CourseService courseService = mock(CourseService.class);
	public CourseController sut = new CourseController(courseService);

	public Course course = mock(Course.class);
	
	
	@Test
	public void shouldGetAllCourses() {
		
		sut.getAllCourses();
		
		verify(courseService).getAllCourses();
	}

	
	
	@Test
	public void shouldSveCourse() {
		
		sut.saveCourse(course);
		
		verify(courseService).saveCourse(course);
	}
	
}
