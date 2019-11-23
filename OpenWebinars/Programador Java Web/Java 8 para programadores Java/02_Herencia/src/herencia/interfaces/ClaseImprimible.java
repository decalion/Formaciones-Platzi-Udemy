package herencia.interfaces;


public class ClaseImprimible implements /*Imprimible,*/ ImprimiblePorConsola {

	@Override
	public void print(String s) {
		System.out.println(s);
	}
	

}
