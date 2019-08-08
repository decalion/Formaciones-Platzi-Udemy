package com.bolsadeideas.springboot.app.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SimpleGrantedAuthorityMixn {

	
	
	@JsonCreator
	public SimpleGrantedAuthorityMixn(@JsonProperty("authority") String role) {

	}
	
	
	

}
