package com.icaballero.hibernate.dao;

import java.util.List;

import com.icaballero.hibernate.model.Teacher;

public interface ITeacherDAO {
	
	
	void saveTeacher(Teacher teacher);
	
	void deletedTeacherById(int idTeacher);
	
	void updateTeacher(Teacher teacher);
	
	List<Teacher> findAllTeacher();
	
	Teacher findTeacherById(int teacher);
	
	Teacher findTeacherByName(String name);
}
