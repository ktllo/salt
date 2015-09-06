package org.leolo.salt;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * This class is a simple plain hash, salted hash, and keyed hash provider, and will result in same format. 
 * This class also provides a verify function to verify the hash.
 * 
 * The hashed string will be in a form of <pre>$alg$salt$hash</pre>, the hash itself will be Base64 encodeds
 * @author leolo
 *
 */
public class Salt {
	//Format is $<AlgroithID>$<salt>$<Base64Hash>
	
	/**
	 * Generate the hash for the given password
	 * @param password The password going to hash
	 * @param type What kind of hash going to use
	 * @return the formated hash
	 */
	public static String createHash(String password,HashType type){
		return createHash(password,SaltGenerator.getInstance().getSalt(10),type);
	}
	
	private static String createHash(String password,String salt,HashType type){
		String hash = "";
		if(type == HashType.MD5){
			hash = new String(Base64.encodeBase64(DigestUtils.md5(password), false));
		}else if(type == HashType.SHA1){
			hash = new String(Base64.encodeBase64(DigestUtils.sha1(password), false));
		}else if(type == HashType.SHA256){
			hash = new String(Base64.encodeBase64(DigestUtils.sha256(password), false));
		}else if(type == HashType.SHA384){
			hash = new String(Base64.encodeBase64(DigestUtils.sha384(password), false));
		}else if(type == HashType.SHA512){
			hash = new String(Base64.encodeBase64(DigestUtils.sha512(password), false));
		}else if(type == HashType.SALTED_MD5){
			hash = new String(Base64.encodeBase64(DigestUtils.md5(salt+password), false));
		}else if(type == HashType.SALTED_SHA1){
			hash = new String(Base64.encodeBase64(DigestUtils.sha1(salt+password), false));
		}else if(type == HashType.SALTED_SHA256){
			hash = new String(Base64.encodeBase64(DigestUtils.sha256(salt+password), false));
		}else if(type == HashType.SALTED_SHA384){
			hash = new String(Base64.encodeBase64(DigestUtils.sha384(salt+password), false));
		}else if(type == HashType.SALTED_SHA512){
			hash = new String(Base64.encodeBase64(DigestUtils.sha512(salt+password), false));
		}else{
			hash = HMAC(password,salt,type);
		}
		return "$"+type.getId()+"$"+salt+"$"+hash;
	}
	
	private static String HMAC(String password,String key,HashType type){
		String opad="",ipad="";
		for(int i=0;i<key.length();i++){
			opad = opad + (key.charAt(i) ^ 0x5c);
			ipad = ipad + (key.charAt(i) ^ 0x36);
		}
		String pass1 = ipad + password;
		byte [] rPass1 = null;
		if(type == HashType.HMAC_MD5){
			rPass1 = DigestUtils.md5(pass1);
		}else if(type == HashType.HMAC_SHA1){
			rPass1 = DigestUtils.sha1(pass1);
		}else if(type == HashType.HMAC_SHA256){
			rPass1 = DigestUtils.sha256(pass1);
		}else if(type == HashType.HMAC_SHA384){
			rPass1 = DigestUtils.sha384(pass1);
		}else if(type == HashType.HMAC_SHA512){
			rPass1 = DigestUtils.sha512(pass1);
		}
		byte [] pass2 = new byte[opad.length()+rPass1.length];
		for(int i=0;i<opad.length();i++){
			pass2[i] = (byte)opad.charAt(i);
		}
		for(int i=0;i<rPass1.length;i++){
			pass2[i+opad.length()] = rPass1[i];
		}
		byte [] rPass2 = null;
		if(type == HashType.HMAC_MD5){
			rPass2 = DigestUtils.md5(pass2);
		}else if(type == HashType.HMAC_SHA1){
			rPass2 = DigestUtils.sha1(pass2);
		}else if(type == HashType.HMAC_SHA256){
			rPass2 = DigestUtils.sha256(pass2);
		}else if(type == HashType.HMAC_SHA384){
			rPass2 = DigestUtils.sha384(pass2);
		}else if(type == HashType.HMAC_SHA512){
			rPass2 = DigestUtils.sha512(pass2);
		}
		return new String(Base64.encodeBase64(rPass2, false));
	}
	
	/**
	 * Verify is the given hash matched the given password. You must ensure the hash given is generated by
	 * <code>createHash(String,HashType)</code> function.
	 * @param password The password going to be checked
	 * @param hash The hash generated by <code>createHash(String,HashType)</code> 
	 * @return true if password matched
	 */
	public static boolean verify(String password,String hash){
		String [] part = hash.split("\\$");
		String algroithm = part[1].trim();
		String salt = part[2].trim();
		String newHash = createHash(password,salt,HashType.getType(algroithm));
		boolean OK = true;
		for(int i=0;i<newHash.length() && i<hash.length();i++){
			if( (newHash.charAt(i) ^ hash.charAt(i)) != '\0'){
				OK = false;
			}
		}
		return OK;
	}
}
