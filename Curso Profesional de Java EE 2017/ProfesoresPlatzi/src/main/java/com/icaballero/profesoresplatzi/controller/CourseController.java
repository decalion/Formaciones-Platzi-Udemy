package com.icaballero.profesoresplatzi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.icaballero.profesoresplatzi.model.Course;
import com.icaballero.profesoresplatzi.model.Teacher;
import com.icaballero.profesoresplatzi.services.ICourseService;
import com.icaballero.profesoresplatzi.util.CustomErrorType;

@Controller
@RequestMapping("/v1")
public class CourseController {

	@Autowired
	ICourseService iCourseService;

	@RequestMapping(value = "/courses", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createCourse(@RequestBody Course course, UriComponentsBuilder uriComponentsBuilder) {

		// Comprobamos que el campo obligatorio nombre no esta vacio
		if (course.getName().equals(null) || course.getName().isEmpty()) {

			return new ResponseEntity(new CustomErrorType("name is requited"), HttpStatus.CONFLICT);
		}

		// verificamos si ya existe el curso
		if (iCourseService.findByName(course.getName()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		// Guardamos el nuevo curso
		iCourseService.saveCourse(course);

		// Buscamos el nuevo curso para obtener su id y generar la url de respuesta
		Course course2 = iCourseService.findByName(course.getName());

		HttpHeaders headers = new HttpHeaders();

		// Generamos la URL respuesta a traves del id del del curso
		headers.setLocation(
				uriComponentsBuilder.path("/v1/courses/{id}").buildAndExpand(course2.getIdCourse()).toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	//GET
	@RequestMapping(value = "/courses", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Course>> getCourses(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "idTeacher", required = false) Integer idTeacher) {

		List<Course> courseList = new ArrayList<Course>();

		if (idTeacher != null) {

			courseList = iCourseService.findByIdTeacher(idTeacher);
			if (courseList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

		}

		if (name != null) {
			Course course = iCourseService.findByName(name);

			if (course == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}

			courseList.add(course);

		}

		//Si los 2 campos estan vacios devuelve la lista de cursos
		if (name == null && idTeacher == null) {

			courseList = iCourseService.findeAllCourse();

			if (courseList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
		}

		return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);

	}
	
	//GET por ID
	@RequestMapping(value = "/courses/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer idCourse){
		
		if (idCourse == null || idCourse <= 0) {

			return new ResponseEntity(new CustomErrorType("idCourse is requited"), HttpStatus.CONFLICT);
		}

		Course course = iCourseService.findCourseById(idCourse);

		if (course == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Course>(course, HttpStatus.OK);
		
		
		
	}
	
	//PATCH
	@RequestMapping(value = "/courses/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<?> updateCourse(@PathVariable("id") Integer idCourse, @RequestBody Course course){
		
		//Comprobamos si el id del coursees correcto
		if (idCourse == null || idCourse <= 0) {

			return new ResponseEntity(new CustomErrorType("idCourse is requited"), HttpStatus.CONFLICT);
		}
		
		//Obtenemos el Course a actualizar a traves del id
		Course currentCourse = iCourseService.findCourseById(idCourse);
		
		//Comprobamos si el course a actualizar existe
		if(currentCourse == null) {
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		//Obetenemos los datos a actualizar
		currentCourse.setName(course.getName());
		currentCourse.setThemes(course.getThemes());
		currentCourse.setProject(course.getProject());
		
		//Actualizamos
		iCourseService.updateCourse(currentCourse);
		
		
		return new ResponseEntity<Course>(HttpStatus.OK);
		
		
	}
	
	//delete
	@RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteCourse(@PathVariable("id") Integer idCourse){
		//Comprobamos si el id del teacher es correcto
		if (idCourse == null || idCourse <= 0) {

			return new ResponseEntity(new CustomErrorType("idCourser is requited"), HttpStatus.CONFLICT);
		}
		
		//Obtenemos el Teacher a eliminar a traves del id
		Course currentCourse = iCourseService.findCourseById(idCourse);
		
		//Comprobamos si el teacher existe
		if(currentCourse== null) {
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		
		iCourseService.deleteCourse(idCourse);

		return new ResponseEntity<Course>(HttpStatus.OK);
		
		
	}
	

}
