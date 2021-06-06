package com.icaballero.arquitecturahexagonal;

public class CourseRequest {

	private String title;
	private Integer duration;

	public CourseRequest(String title, Integer duration) {
		super();
		this.title = title;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	

}
