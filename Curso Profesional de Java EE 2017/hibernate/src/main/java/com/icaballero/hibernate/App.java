package com.icaballero.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.icaballero.hibernate.dao.TeacherDaoImpl;
import com.icaballero.hibernate.model.Course;
import com.icaballero.hibernate.model.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        Teacher teacher = new Teacher("Juan","Avatar");
        
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        teacherDao.saveTeacher(teacher);*/
        
    	
    	
    	
    	TeacherDaoImpl teacherDao = new TeacherDaoImpl();
    	
    	List<Teacher> lista = teacherDao.findAllTeacher();
    	
    	for (Teacher teacher : lista) {
			
    		System.out.println("Nombre " + teacher.getName());
		}
        
       
        
        
    }
}
