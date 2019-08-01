package com.icaballero.hibernate.dao;

import java.util.List;

import com.icaballero.hibernate.model.Teacher;

public class TeacherDaoImpl extends IcaballeroSession implements ITeacherDAO {
	

	private IcaballeroSession session;
	
	
	
	public TeacherDaoImpl() {
		session = new IcaballeroSession();
	}

	public void saveTeacher(Teacher teacher) {
		
		session.getSession().persist(teacher);
		session.getSession().getTransaction().commit();
		
	}

	public void deletedTeacherById(int idTeacher) {
		// TODO Auto-generated method stub
		
	}

	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	public List<Teacher> findAllTeacher() {
		
		
		
		return session.getSession().createQuery("from Teacher").list();
	}

	public Teacher findTeacherById(int teacher) {
		// TODO Auto-generated method stub
		return null;
	}

	public Teacher findTeacherByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
