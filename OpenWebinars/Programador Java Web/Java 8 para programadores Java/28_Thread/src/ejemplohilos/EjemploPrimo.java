/**
 * EJEMPLO DE EJECUCIÓN DE LA CLASE PRIMOTHREAD
 */
package ejemplohilos;


public class EjemploPrimo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PrimoThread pt = new PrimoThread(135);
		pt.start();		
		System.out.println("Este mensaje se imprime pronto");

	}

}
