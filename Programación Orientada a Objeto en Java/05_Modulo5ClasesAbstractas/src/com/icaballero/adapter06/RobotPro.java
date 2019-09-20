package com.icaballero.adapter06;

public class RobotPro extends Robot {
	
	private Rotable brazoPro;
	
	

	public Rotable getBrazoPro() {
		return brazoPro;
	}

	public void setBrazoPro(Rotable brazoPro) {
		this.brazoPro = brazoPro;
	}
	
	
	public void rotarBrazoPro() {
		
		brazoPro.rotar();
		
	}
	
	

}
