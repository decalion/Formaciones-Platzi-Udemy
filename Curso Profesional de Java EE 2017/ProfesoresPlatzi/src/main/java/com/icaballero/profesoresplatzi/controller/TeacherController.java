package com.icaballero.profesoresplatzi.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.icaballero.profesoresplatzi.model.SocialMedia;
import com.icaballero.profesoresplatzi.model.Teacher;
import com.icaballero.profesoresplatzi.model.TeacherSocialMedia;
import com.icaballero.profesoresplatzi.services.ISocialMediaService;
import com.icaballero.profesoresplatzi.services.ITeacherService;
import com.icaballero.profesoresplatzi.util.CustomErrorType;

@Controller
@RequestMapping("/v1")
public class TeacherController {

	@Autowired
	private ITeacherService iTeacherService;
	
	@Autowired
	private ISocialMediaService iSocialMedia;

	public static final String TEACHER_UPLOADER_FOLDER = "images/teachers/";

	// POST PARA Añadir un nuevo Teacher
	@RequestMapping(value = "/teachers", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createTeacher(@RequestBody Teacher teacher, UriComponentsBuilder uriComponentsBuilder) {

		// Comprobamos que el campo obligatorio nombre no esta vacio
		if (teacher.getName().equals(null) || teacher.getName().isEmpty()) {

			return new ResponseEntity(new CustomErrorType("name is requited"), HttpStatus.CONFLICT);
		}

		// verificamos si ya existe el professor
		if (iTeacherService.findTeacherByName(teacher.getName()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		// Guardamos el nuevo profesor
		iTeacherService.saveTeacher(teacher);

		// Buscamos el nuevo profesor para obtener su id y generar la url de respuesta
		Teacher teacher2 = iTeacherService.findTeacherByName(teacher.getName());

		HttpHeaders headers = new HttpHeaders();

		// Generamos la URL respuesta a traves del id del teacher
		headers.setLocation(
				uriComponentsBuilder.path("/v1/teachers/{id}").buildAndExpand(teacher2.getIdTeacher()).toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// GET para obtener la lista de profesores
	@RequestMapping(value = "/teachers", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Teacher>> getTeachers(@RequestParam(value = "name", required = false) String name) {

		List<Teacher> teacherList = new ArrayList<>();

		// Si el campo name esta vacio devolvemos todas las socialmedias
		if (name == null) {
			teacherList = iTeacherService.findAllTeacher();

			if (teacherList.isEmpty()) {

				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<List<Teacher>>(teacherList, HttpStatus.OK);

		} else {

			Teacher teacherName = iTeacherService.findTeacherByName(name);

			// Verificamos que existe en la BBDD
			if (teacherName == null) {

				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}

			teacherList.add(teacherName);

			return new ResponseEntity<List<Teacher>>(teacherList, HttpStatus.OK);

		}

	}

	// GET Obtener profesor por id
	@RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Teacher> geTeacherById(@PathVariable("id") Integer idTeacher) {

		if (idTeacher == null || idTeacher <= 0) {

			return new ResponseEntity(new CustomErrorType("idTeacher is requited"), HttpStatus.CONFLICT);
		}

		Teacher teacher = iTeacherService.findTeacherById(idTeacher);

		if (teacher == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);

	}

	// PATH para actualizar los datos de un teacher
	@RequestMapping(value = "/teachers/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<?> updateTeacher(@PathVariable("id") Integer idTeacher, @RequestBody Teacher teacher) {

		// Comprobamos si el id del teacher es correcto
		if (idTeacher == null || idTeacher <= 0) {

			return new ResponseEntity(new CustomErrorType("idTeacher is requited"), HttpStatus.CONFLICT);
		}

		// Obtenemos el Teacher a actualizar a traves del id
		Teacher currentTeacher = iTeacherService.findTeacherById(idTeacher);

		// Comprobamos si el teacher a actualizar existe
		if (currentTeacher == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		// Obetenemos los datos a actualizar
		currentTeacher.setName(teacher.getName());
		currentTeacher.setAvatar(teacher.getAvatar());

		// Actualizamos
		iTeacherService.updateTeacher(currentTeacher);

		return new ResponseEntity<Teacher>(HttpStatus.OK);

	}

	@RequestMapping(value = "/teachers/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteTeacher(@PathVariable("id") Integer idTeacher) {

		// Comprobamos si el id del teacher es correcto
		if (idTeacher == null || idTeacher <= 0) {

			return new ResponseEntity(new CustomErrorType("idTeacher is requited"), HttpStatus.CONFLICT);
		}

		// Obtenemos el Teacher a eliminar a traves del id
		Teacher currentTeacher = iTeacherService.findTeacherById(idTeacher);

		// Comprobamos si el teacher existe
		if (currentTeacher == null) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		iTeacherService.deletedTeacherById(idTeacher);

		return new ResponseEntity<Teacher>(HttpStatus.OK);

	}

	// CREATE TEACHER IMAGE
	@RequestMapping(value = "/teachers/images", method = RequestMethod.POST, headers = ("content-type=multipart/form-data"))
	public ResponseEntity<byte[]> uploadTeacherImage(@RequestParam("idTeacher") Integer idTeacher,
			@RequestParam("file") MultipartFile multipartFile, UriComponentsBuilder componentsBuilder) {
		if (idTeacher == null) {
			return new ResponseEntity(new CustomErrorType("Please set id_teacher"), HttpStatus.NO_CONTENT);
		}

		if (multipartFile.isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Please select a file to upload"), HttpStatus.NO_CONTENT);
		}

		Teacher teacher = iTeacherService.findTeacherById(idTeacher);

		if (teacher == null) {
			return new ResponseEntity(new CustomErrorType("Teacher with id_teacher: " + idTeacher + " not dfound"),
					HttpStatus.NOT_FOUND);
		}

		if (!teacher.getAvatar().isEmpty() || teacher.getAvatar() != null) {
			String fileName = teacher.getAvatar();
			Path path = Paths.get(fileName);
			File f = path.toFile();
			if (f.exists()) {
				f.delete();
			}
		}

		try {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String dateName = dateFormat.format(date);

			String fileName = String.valueOf(idTeacher) + "-pictureTaecher-" + dateName + "."
					+ multipartFile.getContentType().split("/")[1];
			teacher.setAvatar(TEACHER_UPLOADER_FOLDER + fileName);

			byte[] bytes = multipartFile.getBytes();
			Path path = Paths.get(TEACHER_UPLOADER_FOLDER + fileName);
			Files.write(path, bytes);

			iTeacherService.updateTeacher(teacher);

			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity(
					new CustomErrorType("Error during upload: " + multipartFile.getOriginalFilename()),
					HttpStatus.CONFLICT);
		}
	}
	
	
	
	//GET IMAGES
	@RequestMapping(value = "/teachers/{id}/images", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getTeacherImage(@PathVariable("id") Integer idTeacher){
		
		if(idTeacher == null) {
			return new ResponseEntity(new CustomErrorType("Please set id_teacher"), HttpStatus.NO_CONTENT);
		}
		
		Teacher teacher = iTeacherService.findTeacherById(idTeacher);
		
		if(teacher == null) {
			
			return new ResponseEntity(new CustomErrorType("Teacher with idTeacher: " + idTeacher + "not found"), HttpStatus.NOT_FOUND);
		}
		
		
		try {
			
			String fileName = teacher.getAvatar();
			Path path = Paths.get(fileName);
			File f = path.toFile();
			if(!f.exists()) {
				return new ResponseEntity(
						new CustomErrorType("Image not Found"),HttpStatus.CONFLICT);
			}
			
			byte[] image = Files.readAllBytes(path);
			
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(
					new CustomErrorType("Error to show image"),HttpStatus.CONFLICT);
		}
		
		
	}
	
	//DELETE IMAGE
	@RequestMapping(value = "/teachers/{id}/images", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public ResponseEntity<?> deleteTeacherImage(@PathVariable("id")Integer idtTeacher){
		
		if(idtTeacher == null) {
			return new ResponseEntity(new CustomErrorType("Please set id_teacher"), HttpStatus.NO_CONTENT);
		}
		
		Teacher teacher = iTeacherService.findTeacherById(idtTeacher);
		
		if(teacher == null) {
			
			return new ResponseEntity(new CustomErrorType("Teacher with idTeacher: " + idtTeacher + "not found"), HttpStatus.NOT_FOUND);
		}
		
		if(teacher.getAvatar().isEmpty() || teacher.getAvatar() == null) {
			return new ResponseEntity(new CustomErrorType("This teacher doesn't have  images assigne"), HttpStatus.NO_CONTENT);
		}
		
		String fileName = teacher.getAvatar();
		Path path = Paths.get(fileName);
		File file = path.toFile();
		if(file.exists()) {
			file.delete();
		}
		
		teacher.setAvatar("");
		iTeacherService.updateTeacher(teacher);
		
		return new ResponseEntity<Teacher>(HttpStatus.NO_CONTENT);
		
	}
	
	@RequestMapping(value = "/teachers/socialmedias", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<?> assignTeacherSocialMedia(@RequestBody Teacher teacher, UriComponentsBuilder uriComponentsBuilder){
		
		//Validamos el id teacher recibido
		if(teacher.getIdTeacher() == null) {
			return new ResponseEntity(new CustomErrorType("We need almost idTeacher, idSocialMedia and nickname"), HttpStatus.NOT_FOUND);
			
		}
		
		//Si es correcto buscamos el teacher
		Teacher teacherSaved = iTeacherService.findTeacherById(teacher.getIdTeacher());
		
		//Valimos que hemos obtenido el teacher
		if(teacherSaved == null) {
			return new ResponseEntity(new CustomErrorType("The idTeacher: " + teacher.getIdTeacher() + " NOT FOUND"), HttpStatus.NOT_FOUND);
			
		}
		
		
		//Comprobamos si el objeto teacher  tiene una lista de socialmedias si no tiene devolvemos error
		if(teacher.getTeacherSocialMedia().size() == 0) {
			return new ResponseEntity(new CustomErrorType("We need almost idTeacher, idSocialMedia and nickname"), HttpStatus.NOT_FOUND);
			
		}else {
			
			//Obtenemos la lista de socialmedias e iteremos
			Iterator<TeacherSocialMedia> i = teacher.getTeacherSocialMedia().iterator();
			
			//Inicio de la iteracion
			while(i.hasNext()) {
				
				//Obtenemos la lista de socialmedias
				TeacherSocialMedia teacherSocialMedia = i.next();
				
				//Comprobamos si los campos estan vacios
				if(teacherSocialMedia.getSocialMedia().getIdSocialMedia() == null || teacherSocialMedia.getNickname() == null) {
					return new ResponseEntity(new CustomErrorType("We need almost idTeacher, idSocialMedia and nickname"), HttpStatus.NOT_FOUND);
					
				}else {
					
					//Si no estan vacios validamos si ya hay un teacher que tenga una socialmedia vinculada a un nickname
					
					TeacherSocialMedia tsmAux = iSocialMedia.findSocialMediaByIdAndName(teacherSocialMedia.getSocialMedia().getIdSocialMedia(), teacherSocialMedia.getNickname());
					
					//Si ya esta vinculado devolvemos error
					if(tsmAux != null) {
						return new ResponseEntity(new CustomErrorType("The id social media " + teacherSocialMedia.getSocialMedia().getIdSocialMedia()  + " whith nickname" + teacherSocialMedia.getNickname() +"already exist"), HttpStatus.NOT_FOUND);
						
					}
					
					
					
					//Si no esta vinculado comprobamos si el id socialmedia es correcto
					SocialMedia socialMedia = iSocialMedia.findSocialMediaById(teacherSocialMedia.getSocialMedia().getIdSocialMedia());
					if(socialMedia == null) {
						return new ResponseEntity(new CustomErrorType("The id Social Media not FOUND"), HttpStatus.NOT_FOUND);
					}
					
					
					//Si es correcto guardamos el nickname con el socialmedia
					teacherSocialMedia.setSocialMedia(socialMedia);
					teacherSocialMedia.setTeacher(teacherSaved);
					
					
					//A continuacion se vuelve a revisar para hacer un update de todos los socialmedia
					
					if(tsmAux == null) {
						
						teacherSaved.getTeacherSocialMedia().add(teacherSocialMedia);
						
					}else {
						
						LinkedList<TeacherSocialMedia> teacherSocialMediaList  = new LinkedList<>();
						teacherSocialMediaList.addAll(teacherSaved.getTeacherSocialMedia());
						
						for (int j = 0; j < teacherSocialMediaList.size(); j++) {
							TeacherSocialMedia teacherSocialMedia2 = teacherSocialMediaList.get(j);
							
							if(teacherSocialMedia.getTeacher().getIdTeacher() == teacherSocialMedia2.getTeacher().getIdTeacher() && teacherSocialMedia.getSocialMedia().getIdSocialMedia() == teacherSocialMedia2.getSocialMedia().getIdSocialMedia()) {
								
								teacherSocialMedia2.setNickname(teacherSocialMedia.getNickname());
								teacherSocialMediaList.set(j, teacherSocialMedia2);
								
							}else {
								teacherSocialMediaList.set(j, teacherSocialMedia2);
							}
							
							
						}
						
						teacherSaved.getTeacherSocialMedia().clear();
						teacherSaved.getTeacherSocialMedia().addAll(teacherSocialMediaList);
						
					}
					
					
				}
				
				
				
			}
			
			
		}
		
		iTeacherService.updateTeacher(teacherSaved);
		
		return new ResponseEntity<Teacher>(teacherSaved,HttpStatus.OK);
	}
	

}
