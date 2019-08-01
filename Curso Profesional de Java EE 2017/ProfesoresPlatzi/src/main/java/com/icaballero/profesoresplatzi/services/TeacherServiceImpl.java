package com.icaballero.profesoresplatzi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icaballero.profesoresplatzi.dao.ITeacherDAO;
import com.icaballero.profesoresplatzi.model.Teacher;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements ITeacherService {

	@Autowired
	private ITeacherDAO teacherDAO;
	
	@Override
	public void saveTeacher(Teacher teacher) {
		teacherDAO.saveTeacher(teacher);
		
	}

	@Override
	public void deletedTeacherById(int idTeacher) {
		teacherDAO.deletedTeacherById(idTeacher);
		
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		teacherDAO.updateTeacher(teacher);
	}

	@Override
	public List<Teacher> findAllTeacher() {
		
		return teacherDAO.findAllTeacher();
	}

	@Override
	public Teacher findTeacherById(int teacher) {
		
		return teacherDAO.findTeacherById(teacher);
	}

	@Override
	public Teacher findTeacherByName(String name) {
		
		return teacherDAO.findTeacherByName(name);
	}
	
	

}
