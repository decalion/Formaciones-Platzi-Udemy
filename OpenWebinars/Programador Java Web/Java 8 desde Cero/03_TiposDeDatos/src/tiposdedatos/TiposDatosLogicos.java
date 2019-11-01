package tiposdedatos;

public class TiposDatosLogicos {
	
	public static void main(String[] args) {
		
		//OPERADORES LOGICOS CONDICIONALES
		int valor1 = 1;
		int valor2 = 2;
		
		if((valor1 == 1) && (valor2 == 2)) 
			System.out.println("Valor1 es 1 AND valor2 es 2");
		
		if((valor1 == 1) || (valor2 == 1)) 
			System.out.println("Valor1 es 1 OR valor2 es 1");
		

		//OPERADOR TERNARIO
		int result;
		boolean someCondition = true;
		result = someCondition ? valor1 : valor2;
		System.out.println(result);
		
		
		//OPERADORES LOGICOS RELACIONALES
		if(valor1 == valor2)
			System.out.println("valor1 == valor2");
		if(valor1 != valor2)
			System.out.println("valor1 != valor2");
		if(valor1 > valor2)
			System.out.println("valor1 > valor2");
		if(valor1 < valor2)
			System.out.println("valor1 < valor2");
		if(valor1 <= valor2)
			System.out.println("valor1 <= valor2");
		
	}

}
