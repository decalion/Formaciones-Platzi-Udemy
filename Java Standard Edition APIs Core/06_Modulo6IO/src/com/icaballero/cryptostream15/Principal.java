package com.icaballero.cryptostream15;

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
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Principal {

	public static void main(String[] args) {

		/**
		 * 
		 * Ejemplo de CryptoStream (Stream de cifrado)
		 * 
		 * Leectura de fichero desencriptar
		 * 
		 */

		String claveTexto = "lyBwI0qn8cs=";

		try {

			// Genera la clave en formato byte
			byte[] clave = Base64.getDecoder().decode(claveTexto);

			Key key = new SecretKeySpec(clave, "DES");

			// Ponemos el cifrador en modo desencriptar
			Cipher cifrador = Cipher.getInstance("DES");
			cifrador.init(Cipher.DECRYPT_MODE, key);

			BufferedReader lector = new BufferedReader(
					new InputStreamReader(new CipherInputStream(new FileInputStream("textoEncryptado.txt"), cifrador)));
			
			System.out.println(lector.readLine());
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
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
