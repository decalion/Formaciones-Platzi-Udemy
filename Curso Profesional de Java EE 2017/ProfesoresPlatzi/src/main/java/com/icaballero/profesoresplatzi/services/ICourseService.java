package com.icaballero.profesoresplatzi.services;

import java.util.List;

import com.icaballero.profesoresplatzi.model.Course;

public interface ICourseService {
	
	
	void saveCourse(Course course);
	
	void updateCourse(Course course);
	
	void deleteCourse(int idCourse);
	
	List<Course> findeAllCourse();
	
	Course findCourseById(int idCourse);
	
	Course findByName(String name);
	
	List<Course> findByIdTeacher(int idTeacher);

}
