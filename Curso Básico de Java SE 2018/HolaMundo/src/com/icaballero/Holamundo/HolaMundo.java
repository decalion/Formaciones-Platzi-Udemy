package com.icaballero.Holamundo;

public class HolaMundo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hola Mundo :)");

		// Enteros
		byte edad = 2; // va del -128 a 127 (en memoria ocupa 1 byte)
		short year = 2220; // va del -32768 al 32767(En memoria ocupa 2 byte)
		int id = 1001; // va del -2.147.483.648 al 2.147.483.647(En memoria
						// ocupa 4 byte)
		long id_U = 1131414134141L; // (Ocupa en memoria 8 bytes) Añadir la L al
									// final para decir que es long

		// Flotantes (Con decimales)
		float diametro = 34.25F; // (Añadir la F al final para decir que es
									// float)
		double precio = 2.8988;

		// Datos de texto
		char letra = 'M'; // (Ocupa en memoria 2 bytes)

		// Datos logicos
		boolean isVisible = true; // Ocupa 2 byte en memoria)
		boolean funciona = false;

		// Arrays
		// Decalaracion
		int[] arregloInt = new int[2];
		double arregloDouble[];
		int[][] array2D = new int[2][3]; // 2 filas 3 columnas
		int[][][] array3D = new int[3][3][2];
		int[][][][] array4D = new int[1][2][3][4];

		// Definir el contenido
		char[][] days = { { 'M', 'T', 'w' }, { 'M', 'T', 'w' } }; // Array de 2
																	// dimensiones
		char[][][] letters = { { { 'M', 'T', 'w' }, { 'a', 'b', 'c' } }, { { 'M', 'T', 'w' }, { 'a', 'b', 'c' } } };

		char[] names = new char[4];
		names[0] = 'h';
		names[1] = 'o';
		names[2] = 'l';
		names[3] = 'a';

		char[][][][] monkey = new char[2][3][2][2];
		monkey[1][0][0][1] = 'M';
		System.out.println(monkey[1][0][0][1]);

		// operadores
		int a = 1;
		int aa = a + a;
		System.out.println("El valor de aa: " + aa);

		double x = 2.56;
		int y = 9;
		float w = (float) x + y;
		System.out.println(w);
		System.out.println(w * 2);

		double k = 4 / 0.00002;
		System.out.println(k);
		System.out.println(7 % 2);

		int f = 2;
		int g = 3;
		// f= f+g;
		f += g;
		System.out.println(f);

		// incremento y decrementos
		int l = 3;
		// l++;
		// ++l;
		// System.out.println(l);

		// Prefijo ++l
		// 1.incremento el valor l+1
		// 2.asignar el valor a l

		// System.out.println(++l);

		// posfijo
		// l++
		// 1.asignar el valor l l=l
		// 2.incrementa el valor
		System.out.println(l++);// imprime 3
		System.out.println(l);// imprime 4 ya que lo ha sumado despues de
								// imprimir

		// Oeperadores de igualdad
		int q = 5;
		int p = 4;

		System.out.println(q == p);// q es igual que ? p
		System.out.println(q != p);// q es diferente que ? p

		// operadores relacionales
		System.out.println("Q es mayor que p ? :" + (q > p));
		System.out.println("Q es menor que p ? :" + (q < p));
		System.out.println("Q es mayor o igual que p ? :" + (q >= p));
		System.out.println("Q es menor o igual que p ? :" + (q <= p));

		// operadores logicos

		boolean n = false;
		boolean m = true;
		System.out.println("n && m -> " + (n && m));// si n y m son verdareros
													// devuelve true si no falso
		System.out.println("n || m -> " + (n || m));// si n o m es verdaredo
													// devuelve true
		System.out.println("!n-> " + (!n));// si n es falso devuelve true

		// Control de flujo

		// EJEMPLO IF/ELSE
		if (q > p) {
			// true
			System.out.println("q es mayor que p");
		} else if (q == p) {
			System.out.println("q es igual que p");
		} else {
			// false
			System.out.println("q no es mayor que p");
		}

		// Ejemplo switch
		int mes = 8;

		switch (mes) {
		case 1:
			System.out.println("Enero");
			break;
		case 2:
			System.out.println("Febrero");
			break;
		case 3:
			System.out.println("Marzo");
			break;
		case 4:
			System.out.println("Abril");
			break;
		case 5:
			System.out.println("Mayo");
			break;
		case 6:
			System.out.println("Junio");
			break;
		case 7:
			System.out.println("Julio");
			break;
		case 8:
			System.out.println("Agosto");
			break;
		case 9:
			System.out.println("Septiembre");
			break;
		case 10:
			System.out.println("Octubre");
			break;
		case 11:
			System.out.println("Noviembre");
			break;
		case 12:
			System.out.println("Diciembre");
			break;
		default:
			System.out.println("No existe el mes");
			break;
		}

		// Bucle while

		int e = 1;
		while (e <= 5) {
			System.out.println("e :" + e);
			e++;

		}

		// bucle for
		int[] numeros = new int[5];
		for (int c = 0; c < 5; c++) {
			numeros[c] =c+1;
			System.out.println("numeros["+c+"]" + numeros[c]);

		}
		//Foreach
		for (int j : numeros) {
			
			System.out.println(j);
		}
		
		
		
		
		
	}

}
