package com.icaballero.arquitecturahexagonal.adapters.secundary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.icaballero.arquitecturahexagonal.domain.Course;
import com.icaballero.arquitecturahexagonal.ports.secundary.CourseRepository;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

	
	private List<Course> courses = new ArrayList<Course>();
	
	
	
	@Override
	public List<Course> findAllCourses() {
		
		return courses;
	}

	@Override
	public Course save(Course course) {
		courses.add(course);
		
		return course;
	}

	
	public void addCourse(Course course) {
		courses.add(course);
	}
}
