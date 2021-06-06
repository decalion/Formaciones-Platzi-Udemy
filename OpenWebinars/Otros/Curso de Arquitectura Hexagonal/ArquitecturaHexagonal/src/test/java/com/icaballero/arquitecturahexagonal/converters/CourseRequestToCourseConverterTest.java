package com.icaballero.arquitecturahexagonal.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mapstruct.factory.Mappers;

import com.icaballero.arquitecturahexagonal.CourseRequest;
import com.icaballero.arquitecturahexagonal.domain.Course;

public class CourseRequestToCourseConverterTest {
	
	Course course = new Course("Curso 1", 60);
	CourseRequest courseRequest = new CourseRequest("Curso 1", 60);

	CourseRequestToCourseConverter converter = Mappers.getMapper(CourseRequestToCourseConverter.class);
	
	@Test
	public void shouldConvertRequestToDomain() {
		
		Course courseActual = converter.converToCourse(courseRequest);
		assertEquals(course, courseActual);
	}

}
