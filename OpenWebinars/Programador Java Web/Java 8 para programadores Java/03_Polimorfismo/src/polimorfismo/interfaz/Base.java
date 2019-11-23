/**
 *  Interfaz Base (para la herencia)
 */
package polimorfismo.interfaz;


public interface Base {
	
	default public void saludar(String mensaje) {
		System.out.println(mensaje + " desde Base");
	}

}
