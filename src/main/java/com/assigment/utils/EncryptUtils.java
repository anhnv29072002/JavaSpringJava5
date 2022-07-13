package com.assigment.utils;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptUtils {

	public static String encrypt(String origin) {
		String encrypted = BCrypt.gensalt();
		return encrypted;
	}

	public static boolean check(String origin, String encrypted) {
		return BCrypt.checkpw(origin, encrypted);
	}

}
