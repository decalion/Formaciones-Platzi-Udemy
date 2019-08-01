package com.icaballero.profesoresplatzi.dao;

import java.util.List;

import com.icaballero.profesoresplatzi.model.Course;

public interface ICourseDAO {
	
	void saveCourse(Course course);
	
	void updateCourse(Course course);
	
	void deleteCourse(int idCourse);
	
	List<Course> findeAllCourse();
	
	Course findCourseById(int idCourse);
	
	Course findByName(String name);
	
	List<Course> findByIdTeacher(int idTeacher);

}
