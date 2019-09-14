package com.icaballero.cryptostream14;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

public class Principal {

	public static void main(String[] args) {

		/**
		 * 
		 * Ejemplo de CryptoStream (Stream de cifrado)
		 * 
		 * 1.Generamos la clave de cifrado (Aleatoriamente)
		 * 2.Creamos el cifrador y endicamos que tiene que cifrar y que utilice la clave generada
		 * 
		 * 
		 * 
		 */
		
		try {
			//Preparamos el generador para que se genere una clave aleatoria
			KeyGenerator generador = KeyGenerator.getInstance("DES");
			generador.init(56,new SecureRandom());
			
			//Generamos la clave
			Key clave = generador.generateKey();
			
			System.out.println(Base64.getEncoder().encodeToString(clave.getEncoded()));
			
			//Creamos el cifrador
			Cipher cifrador = Cipher.getInstance("DES");
			cifrador.init(Cipher.ENCRYPT_MODE, clave);
			
			//Mensaje a encriptar
			String mensaje = "Hola que tal estas";
			
			//Fichero que tendra el mensaje encriptado
			FileOutputStream salida = new FileOutputStream("textoEncryptado.txt");
			CipherOutputStream salidaCiftada = new CipherOutputStream(salida, cifrador);
			BufferedWriter salidaTexto = new BufferedWriter(new OutputStreamWriter(salidaCiftada));
			
			salidaTexto.write(mensaje);
			salidaTexto.close();
			
			
			
			
			
			
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
