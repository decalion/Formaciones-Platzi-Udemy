package com.icaballero.profesoresplatzi.dao;

import java.util.List;

import com.icaballero.profesoresplatzi.model.SocialMedia;
import com.icaballero.profesoresplatzi.model.TeacherSocialMedia;

public interface ISocialMediaDAO {
	
	
	void saveSocialMedia(SocialMedia socialMedia);
	
	void deleteSocialMedia(int idSocialMedia);
	
	void updateSocialMedia(SocialMedia socialMedia);
	
	List<SocialMedia> findAllSocialMedia();
	
	SocialMedia findSocialMediaById(int idSocialMedia);
	
	SocialMedia findByName(String name);
	
	TeacherSocialMedia findSocialMediaByIdAndName(int idSocialMedia, String nickname);
	TeacherSocialMedia findSocialMediaByIdTeacherAndIdSocialMedia(Integer idTeacher, Integer idSocialMedia);
	


}
