package org.leolo.salt;

import java.security.SecureRandom;

public class SaltGenerator {
	
	private static final String AVAILABLE_CHARACTERS = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
	
	private static SaltGenerator instance = null;
	private SecureRandom rng = null;
	
	private SaltGenerator(){
		rng = new SecureRandom();
	}
	
	public static SaltGenerator getInstance(){
		if(instance == null){
			synchronized(SaltGenerator.class){
				if(instance == null){
					instance = new SaltGenerator();
				}
			}
		}
		return instance;
	}
	
	public String getSalt(int length){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<length;i++){
			sb.append(AVAILABLE_CHARACTERS.charAt(rng.nextInt(AVAILABLE_CHARACTERS.length())));
		}
		return sb.toString();
	}
}
