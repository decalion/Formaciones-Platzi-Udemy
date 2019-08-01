package com.icaballero.profesoresplatzi.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.icaballero.profesoresplatzi.model.SocialMedia;
import com.icaballero.profesoresplatzi.model.TeacherSocialMedia;





@Repository
@Transactional
public class SocialMediaDaoImpl extends AbstractSession implements ISocialMediaDAO {

	@Override
	public void saveSocialMedia(SocialMedia socialMedia) {
		
		getSession().persist(socialMedia);
		
	}

	@Override
	public void deleteSocialMedia(int idSocialMedia) {
		SocialMedia socialMedia = findSocialMediaById(idSocialMedia);
		
		if(socialMedia !=null ) {
			getSession().delete(socialMedia);
		}
		
	}

	@Override
	public void updateSocialMedia(SocialMedia socialMedia) {
		getSession().update(socialMedia);
	}

	@Override
	public List<SocialMedia> findAllSocialMedia() {
		
		return getSession().createQuery("from SocialMedia").list();
	}

	@Override
	public SocialMedia findSocialMediaById(int idSocialMedia) {
		
		return (SocialMedia) getSession().get(SocialMedia.class, idSocialMedia);
	}

	@Override
	public SocialMedia findByName(String name) {
		// TODO Auto-generated method stub
		return (SocialMedia) getSession().createQuery("from SocialMedia where name = :name").setParameter("name", name).uniqueResult();
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndName(int idSocialMedia, String nickname) {
		
		
		List<Object[]> objects = getSession().createQuery(
				"from TeacherSocialMedia tsm join tsm.SocialMedia sm where sm.idSocialMedia = :idSocialMedia and tsm.nickname = :nickname")
				.setParameter("idSocialMedia", idSocialMedia).setParameter("nickname", nickname).list();
		
		if(objects.size() > 0) {
			
			for (Object[] objects2 : objects) {
				for (Object object : objects2) {
					
					if(object instanceof TeacherSocialMedia) {
						
						return (TeacherSocialMedia)object;
					}
					
				}
				
			}
		}
		
		return null;
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdTeacherAndIdSocialMedia(Integer idTeacher, Integer idSocialMedia) {
		List<Object[]> objs = getSession().createQuery(
				"from TeacherSocialMedia tsm join tsm.socialMedia sm "
				+ "join tsm.teacher t where sm.idSocialMedia = :id_social_media "
				+ "and t.idTeacher = :id_teacher")
				.setParameter("id_social_media", idSocialMedia)
				.setParameter("id_teacher", idTeacher).list();
		
		if (objs.size()>0) {
			for (Object[] objects : objs) {
				for (Object object : objects) {
					if (object instanceof TeacherSocialMedia) {
						return (TeacherSocialMedia) object;
					}
				}
			}
		}
		return null;
		
	}


}
