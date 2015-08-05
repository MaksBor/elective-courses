package com.epam.lab.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.epam.lab.log.MyLogger;

public class MD5Hashing {

	public static String getHesh(String password){
		 StringBuffer sb=null;
		try {
			MessageDigest ms = MessageDigest.getInstance("MD5");
			ms.update(password.getBytes());
			
			  //convert the byte to hex format method 1
			 byte byteData[] = ms.digest();
	       sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	 
	      
	 
		} catch (NoSuchAlgorithmException e) {
			MyLogger.log.error(e);
		}
		return sb.toString();
	}
}
