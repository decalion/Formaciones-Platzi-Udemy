package com.icaballero.profesoresplatzi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icaballero.profesoresplatzi.dao.ICourseDAO;
import com.icaballero.profesoresplatzi.model.Course;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements ICourseService{

	@Autowired
	private ICourseDAO courseDAO;
	
	
	@Override
	public void saveCourse(Course course) {
		courseDAO.saveCourse(course);
		
	}

	@Override
	public void updateCourse(Course course) {
		courseDAO.updateCourse(course);
		
	}

	@Override
	public void deleteCourse(int idCourse) {
		courseDAO.deleteCourse(idCourse);
		
	}

	@Override
	public List<Course> findeAllCourse() {
		
		return courseDAO.findeAllCourse();
	}

	@Override
	public Course findCourseById(int idCourse) {

		return courseDAO.findCourseById(idCourse);
	}

	@Override
	public Course findByName(String name) {
		
		return courseDAO.findByName(name);
	}

	@Override
	public List<Course> findByIdTeacher(int idTeacher) {
		
		return courseDAO.findByIdTeacher(idTeacher);
	}

}
