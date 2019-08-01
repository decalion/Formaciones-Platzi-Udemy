package com.icaballero.profesoresplatzi.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icaballero.profesoresplatzi.dao.ISocialMediaDAO;
import com.icaballero.profesoresplatzi.model.SocialMedia;
import com.icaballero.profesoresplatzi.model.TeacherSocialMedia;


@Service("socialMediaService")
@Transactional
public class SocialMediaServiceImpl implements ISocialMediaService {

	@Autowired
	private ISocialMediaDAO socialMediaDo;
	
	
	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {
		socialMediaDo.saveSocialMedia(socialMedia);
		
	}

	@Override
	public void deleteSocialMedia(int idSocialMedia) {
		socialMediaDo.deleteSocialMedia(idSocialMedia);
		
	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {
		socialMediaDo.updateSocialMedia(socialMedia);
		
	}

	@Override
	public List<SocialMedia> findAllSocialMedia() {
		
		return socialMediaDo.findAllSocialMedia();
	}

	@Override
	public SocialMedia findSocialMediaById(int idSocialMedia) {
		
		return socialMediaDo.findSocialMediaById(idSocialMedia);
	}

	@Override
	public SocialMedia findByName(String name) {
		
		return socialMediaDo.findByName(name);
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndName(int idSocialMedia, String nickname) {
		
		return socialMediaDo.findSocialMediaByIdAndName(idSocialMedia, nickname);
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdTeacherAndIdSocialMedia(Integer idTeacher, Integer idSocialMedia) {
		// TODO Auto-generated method stub
		return socialMediaDo.findSocialMediaByIdTeacherAndIdSocialMedia(idTeacher, idSocialMedia);
	}
	
	
	

}
