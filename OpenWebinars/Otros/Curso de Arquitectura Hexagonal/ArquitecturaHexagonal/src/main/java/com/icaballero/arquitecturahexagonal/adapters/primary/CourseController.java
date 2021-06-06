package com.icaballero.arquitecturahexagonal.adapters.primary;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icaballero.arquitecturahexagonal.CourseRequest;
import com.icaballero.arquitecturahexagonal.converters.CourseRequestToCourseConverter;
import com.icaballero.arquitecturahexagonal.domain.Course;
import com.icaballero.arquitecturahexagonal.ports.primary.CourseService;

@RequestMapping("/courses")
@RestController
public class CourseController {
	
	
	private CourseService courseService;
	
	private CourseRequestToCourseConverter converter = Mappers.getMapper(CourseRequestToCourseConverter.class);
	
	public CourseController(CourseService courseService) {
		
		this.courseService = courseService;
	}
	

	@GetMapping
	public List<Course> getAllCourses() {
		
		return courseService.getAllCourses();
	}


	@PostMapping
	public Course saveCourse(@RequestBody CourseRequest course) {
		
		Course courseConverter = converter.converToCourse(course);
		
		return courseService.saveCourse(courseConverter);
		
		
	}


}
