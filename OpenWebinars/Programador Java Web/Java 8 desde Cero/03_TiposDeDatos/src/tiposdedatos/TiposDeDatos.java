package tiposdedatos;

public class TiposDeDatos {

	public static void main(String[] args) {

		/**
		 * LITERALES
		 */
		boolean resultado = true;

		char letraMayuscula = 'C';

		byte by = 100;

		short sh = 1000;

		int in = 1000000;

		// Valor 26 decimal
		int decVal = 26;
		// Valor 26 hexadecimal
		int hexVal = 0x1a;
		// Valor 26 binario
		int binVal = 0b11010;
		
		
		/**
		 * TIPOS DE DATOS NUMERICOS
		 */
		
		byte b= 28;
		short s = 3458;
		int i = 33456;
		long l = 3_000_000_000L;
		
		float f = 0.25f;
		double PI = Math.PI;
		
		
		//OPERADORES
		int x = 7;
		int y = 5;
		
		//Suma
		int z = x + y;
		System.out.println("Suma ");
		System.out.println(z);
		
		//Resta
		 z = x - y;
		 System.out.println("Resta ");
		 System.out.println(z);
				
		//Multiplicacion
		 z = x * y;
		 System.out.println("Multiplicacion ");
		 System.out.println(z);
		 
		//Division (Entera)
		 z = x / y;
		 System.out.println("Division entera ");
		 System.out.println(z);
		 
			//Division (Entera)
		 double j = PI/f;
		 System.out.println("Division con decimales ");
		 System.out.println(j);
		 
		//Resto
		 z = x % y;
		 System.out.println("Modulo o Resto ");
		 System.out.println(z);
		 
		 //Incremento
		 z = ++x;
		System.out.println("Incremento ");
		System.out.println(z);
		
		//OPERADORES A NIVEL DE BITS
		
		int bitmask = 0b0011;
		int val = 0b1111;
		
		int res = val & bitmask; //0011
		System.out.println("AND ");	
		System.out.println(Integer.toBinaryString(res));
		
		res = val ^ bitmask; //1100
		System.out.println("OR exclusivo");	
		System.out.println(Integer.toBinaryString(res));
		
		res = val | bitmask; //1111
		System.out.println("OR inclusivo");	
		System.out.println(Integer.toBinaryString(res));
		
		res = val << 1; //11110
		System.out.println("left shift");	
		System.out.println(Integer.toBinaryString(res));
		
		res = val >> 2; //11
		System.out.println("Signed right shift");	
		System.out.println(Integer.toBinaryString(res));
		 
		res = (-val) >> 2; //11111111111111111111111111111100
		System.out.println("Signed right shift");	
		System.out.println(Integer.toBinaryString(res));
		
		res = val >>> 1; //111
		System.out.println("unsigned right shift");	
		System.out.println(Integer.toBinaryString(res));
		

		
		
	}

}
