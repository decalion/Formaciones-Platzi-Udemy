package com.icaballero.arquitecturahexagonal.ports.primary;

import java.util.List;

import org.springframework.stereotype.Service;

import com.icaballero.arquitecturahexagonal.domain.Course;
import com.icaballero.arquitecturahexagonal.ports.secundary.CourseRepository;

@Service
public class CourseService {
	
	
	private CourseRepository repository;
	
	

	public CourseService(CourseRepository repository) {
		super();
		this.repository = repository;
	}



	public List<Course> getAllCourses() {
		
		return repository.findAllCourses();
	}



	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		return repository.save(course);
	}

}
