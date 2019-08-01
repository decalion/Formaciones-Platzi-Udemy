package com.icaballero.profesoresplatzi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.icaballero.profesoresplatzi.model.Course;



@Repository
@Transactional
public class CourseDaoImpl extends AbstractSession implements ICourseDAO {

	@Override
	public void saveCourse(Course course) {
		getSession().persist(course);
		
	}

	@Override
	public void updateCourse(Course course) {
		getSession().update(course);
		
	}

	@Override
	public void deleteCourse(int idCourse) {
		Course course = findCourseById(idCourse);
		
		if(course != null) {
			getSession().delete(course);
		}
		
	}

	@Override
	public List<Course> findeAllCourse() {
		
		return getSession().createQuery("from Course").list();
	}

	@Override
	public Course findCourseById(int idCourse) {
		// TODO Auto-generated method stub
		return (Course) getSession().get(Course.class, idCourse);
	}

	@Override
	public Course findByName(String name) {
		// TODO Auto-generated method stub
		return (Course) getSession().createQuery("from Course where name = :name").setParameter("name", name).uniqueResult();
	}

	@Override
	public List<Course> findByIdTeacher(int idTeacher) {
		// TODO Auto-generated method stub
		return (List<Course>) getSession().createQuery("from Course c join c.teacher t where t.idTeacher = :idTeacher").setParameter("idTeacher", idTeacher).list();
	}

}
