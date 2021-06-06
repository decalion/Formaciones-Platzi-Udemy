package com.icaballero.arquitecturahexagonal.ports.secundary;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icaballero.arquitecturahexagonal.domain.Course;

@Repository
public interface CourseRepository {
	
	List<Course> findAllCourses();

	Course save(Course course);

}
