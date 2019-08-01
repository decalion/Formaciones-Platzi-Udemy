package com.icaballero.profesoresplatzi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.icaballero.profesoresplatzi.model.SocialMedia;
import com.icaballero.profesoresplatzi.services.ISocialMediaService;
import com.icaballero.profesoresplatzi.util.CustomErrorType;

@Controller
@RequestMapping("/v1")
public class SocialMediaController {

	@Autowired
	private ISocialMediaService iSocialMedia;

	// GET
	@RequestMapping(value="/socialMedias", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<SocialMedia>> getSocialMedia(@RequestParam(value = "name", required = false) String name){
		
		List<SocialMedia> socialMedia = new ArrayList<>();
		
		//Si el campo name esta vacio devolvemos todas las socialmedias
		if(name == null) {
			
			socialMedia = iSocialMedia.findAllSocialMedia();
			
			if(socialMedia.isEmpty()) {
				
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<SocialMedia>>(socialMedia,HttpStatus.OK);
		
		//Si el se indica el campo nombre	
		}else {
			
			
			SocialMedia socialMediaName = iSocialMedia.findByName(name);
			//Verificamos que existe en la BBDD
			if(socialMediaName == null) {
				
				return  new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			
			socialMedia.add(socialMediaName);
			
			return new ResponseEntity<List<SocialMedia>>(socialMedia,HttpStatus.OK);
			
		}
		

	}

	// GET por ID
	@RequestMapping(value = "/socialMedias/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<SocialMedia> getSocialMediaById(@PathVariable("id") Integer idSocialMedia) {

		if (idSocialMedia == null || idSocialMedia <= 0) {

			return new ResponseEntity(new CustomErrorType("idSocialMedia is requited"), HttpStatus.CONFLICT);
		}

		SocialMedia socialMedia = iSocialMedia.findSocialMediaById(idSocialMedia);

		if (socialMedia == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<SocialMedia>(socialMedia, HttpStatus.OK);
	}

	

	// POST
	@RequestMapping(value = "/socialMedias", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createSocialMedia(@RequestBody SocialMedia socialMedia,
			UriComponentsBuilder uriComponentBuilder) {

		// Verificamos si los campos obligatorio estan llenos
		if (socialMedia.getName().equals(null) || socialMedia.getName().isEmpty()) {

			return new ResponseEntity(new CustomErrorType("name is requited"), HttpStatus.CONFLICT);
		}

		// verifixamos si exite ya ese social Media
		if (iSocialMedia.findByName(socialMedia.getName()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		}
		// Guardamos el nuevo social Media
		iSocialMedia.saveSocialMedia(socialMedia);

		// Generamos el header de respuesta apartir del id del nuevo social media
		SocialMedia socialMedia2 = iSocialMedia.findByName(socialMedia.getName());
		HttpHeaders headers = new HttpHeaders();

		headers.setLocation(uriComponentBuilder.path("/v1/socialMedias{id}")
				.buildAndExpand(socialMedia2.getIdSocialMedia()).toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

	// UPDATE
	@RequestMapping(value = "/socialMedias/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
	public ResponseEntity<?> updateSocialMedia(@PathVariable("id") Integer idSocialMedia,
			@RequestBody SocialMedia socialMedia) {

		if (idSocialMedia == null || idSocialMedia <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		SocialMedia currentSocialMedia = iSocialMedia.findSocialMediaById(idSocialMedia);

		if (currentSocialMedia == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		}

		currentSocialMedia.setName(socialMedia.getName());
		currentSocialMedia.setIcon(socialMedia.getIcon());

		iSocialMedia.updateSocialMedia(currentSocialMedia);

		return new ResponseEntity<SocialMedia>(currentSocialMedia, HttpStatus.OK);

	}

	// DELETED
	@RequestMapping(value = "/socialMedias/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteSocialMedia(@PathVariable("id") Integer idSocialMedia) {

		if (idSocialMedia == null || idSocialMedia <= 0) {

			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		SocialMedia socialMedia = iSocialMedia.findSocialMediaById(idSocialMedia);

		if (socialMedia == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		}

		iSocialMedia.deleteSocialMedia(idSocialMedia);

		return new ResponseEntity<SocialMedia>(HttpStatus.OK);
	}

}
