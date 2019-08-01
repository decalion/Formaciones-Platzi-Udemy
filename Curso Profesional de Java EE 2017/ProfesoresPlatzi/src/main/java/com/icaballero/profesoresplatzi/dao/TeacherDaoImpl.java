package com.icaballero.profesoresplatzi.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.icaballero.profesoresplatzi.model.Teacher;
import com.icaballero.profesoresplatzi.model.TeacherSocialMedia;


@Repository
@Transactional
public class TeacherDaoImpl extends AbstractSession  implements ITeacherDAO {
	


	@Override
	public void saveTeacher(Teacher teacher) {
		
		getSession().persist(teacher);
	
		
	}

	@Override
	public void deletedTeacherById(int idTeacher) {
		
		Teacher teacher = findTeacherById(idTeacher);
		
		if(teacher != null) {
			
			Iterator<TeacherSocialMedia> i = teacher.getTeacherSocialMedia().iterator();
			
			while(i.hasNext()) {
				TeacherSocialMedia teacherSocialMedia = i.next();
				i.remove();
				getSession().delete(teacherSocialMedia);
			}
			teacher.getTeacherSocialMedia().clear();
			getSession().delete(teacher);
		}
		
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		
		getSession().update(teacher);
		
	}

	@Override
	public List<Teacher> findAllTeacher() {
		
		return getSession().createQuery("from Teacher").list();
	}

	@Override
	public Teacher findTeacherById(int teacher) {
		
		return getSession().get(Teacher.class, teacher);
	}

	@Override
	public Teacher findTeacherByName(String name) {
		
		return (Teacher) getSession().createQuery("from Teacher where name = :name").setParameter("name", name).uniqueResult();
	}
	
	

}
