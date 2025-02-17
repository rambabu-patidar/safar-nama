package com.safar.utils;

import java.util.UUID;

public class GenerateRandomId {
	// Generate a unique random ID.
	public static String generateRandomString() {
		
		return UUID.randomUUID().toString().replace("-","");
	}
}
