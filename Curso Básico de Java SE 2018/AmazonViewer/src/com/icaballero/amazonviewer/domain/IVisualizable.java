package com.icaballero.amazonviewer.domain;

import java.util.Date;

public interface IVisualizable {
	
	Date startToSee(Date dateI);
	void stopToSee(Date dateI , Date dateF);

}
