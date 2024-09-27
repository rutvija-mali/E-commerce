package com.demo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class passwordHashing {

	public static String doHashing(String password)
	{
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(password.getBytes());
		byte[] byteArrayOfPassword = messageDigest.digest();
		
		StringBuilder sb = new StringBuilder(); 
		for(byte b :byteArrayOfPassword )
		{
			sb.append(String.format("%02X", b));
		}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
		
			e.printStackTrace();
		}
		return null;
	}
}
