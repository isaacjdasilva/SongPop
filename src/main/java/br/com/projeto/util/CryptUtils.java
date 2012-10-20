package br.com.projeto.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptUtils {
	
	/**
	 * Generate a MD5 hash with the received text and transform to HEXA
	 * @param <code>String</code> input, with text
	 * @return <code>String</code>, return null if have any error
	 */
	public static String md5(String input)	{
		if (input != null)	{
			byte[] inputBytes = input.getBytes();  
			
			MessageDigest md5 = null;
			
			try {
				md5 = MessageDigest.getInstance("MD5");
				
				byte[] result = md5.digest(inputBytes);
				
				if (result != null)	{
					StringBuffer hexa = new StringBuffer();

			         for (int i = 0; i < result.length; i++) {
			            if ((0xff & result[ i ]) < 0x10)	{
			               hexa.append("0" + Integer.toHexString((0xFF & result[ i ])));
			            }	else	{
			               hexa.append(Integer.toHexString(0xFF & result[ i ]));
			            }
			         }

			         return  hexa.toString();
				}
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}  
		}
		
		return null;
	}
	


}
