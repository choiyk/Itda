package com.kyung.utils;

import java.security.MessageDigest;

public class Encryption {
	public static final String SHA256 = "SHA-256";
	
	public static String encrypt(String s, String messageDigest) {
		try {
			MessageDigest md = MessageDigest.getInstance(messageDigest);
			byte[] passBytes = s.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<digested.length; i++)
				sb.append(Integer.toHexString(0xff & digested[i]));
			return sb.toString();
		}catch (Exception e) {
			return s;
		}
	}
}
