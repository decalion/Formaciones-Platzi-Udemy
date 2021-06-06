package com.icaballero.arquitecturahexagonal.ports.primary;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import com.icaballero.arquitecturahexagonal.domain.Course;
import com.icaballero.arquitecturahexagonal.ports.secundary.CourseRepository;

public class CoursesServiceTest {
	
	private CourseRepository repository = mock(CourseRepository.class);
	
	private CourseService sut = new CourseService(repository);

	public Course course = mock(Course.class);
	
	@Test
	public void shouldGetAllCourses() {
		sut.getAllCourses();
		
		verify(repository).findAllCourses();
	}


	@Test
	public void shouldSveCourse() {
		
		sut.saveCourse(course);
		
		verify(repository).save(course);
	}
	
	
	
}
