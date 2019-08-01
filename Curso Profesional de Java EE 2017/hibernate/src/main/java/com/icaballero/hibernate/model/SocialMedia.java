package com.icaballero.hibernate.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author ismael
 *
 */
@Entity
@Table(name = "social_medial")
public class SocialMedia  implements Serializable{
	
	@Id
	@Column(name = "id_social_media")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSocialMedia;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "icono")
	private String icon;
	
	@OneToMany
	@JoinColumn(name = "id_social_media")
	private Set<TeacherSocialMedia> teacherSocialMedia;
	

	public SocialMedia() {

	}
	
	
	public SocialMedia(String name, String icon) {
		this.name = name;
		this.icon = icon;
	}


	public int getIdSocialMedia() {
		return idSocialMedia;
	}
	
	public void setIdSocialMedia(int idSocialMedia) {
		this.idSocialMedia = idSocialMedia;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIcon() {
		return icon;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}


	public Set<TeacherSocialMedia> getTeacherSocialMedia() {
		return teacherSocialMedia;
	}


	public void setTeacherSocialMedia(Set<TeacherSocialMedia> teacherSocialMedia) {
		this.teacherSocialMedia = teacherSocialMedia;
	}
	


}
