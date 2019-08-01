package com.icaballero.profesoresplatzi.services;

import java.util.List;

import com.icaballero.profesoresplatzi.model.Teacher;

public interface ITeacherService {
	
	
	void saveTeacher(Teacher teacher);
	
	void deletedTeacherById(int idTeacher);
	
	void updateTeacher(Teacher teacher);
	
	List<Teacher> findAllTeacher();
	
	Teacher findTeacherById(int teacher);
	
	Teacher findTeacherByName(String name);

}
