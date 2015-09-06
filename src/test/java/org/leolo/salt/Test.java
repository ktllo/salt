package org.leolo.salt;

public class Test {
	public static void main(String [] args){
		String password = "tomcat";
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.MD5));
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.SHA1));
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.SHA256));
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.SHA384));
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.SHA512));
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.SALTED_MD5));
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.SALTED_SHA1));
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.SALTED_SHA256));
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.SALTED_SHA384));
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.SALTED_SHA512));
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.HMAC_MD5));
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.HMAC_SHA1));
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.HMAC_SHA256));
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.HMAC_SHA384));
		System.out.print(password+" : ");
		System.out.println(Salt.createHash(password, HashType.HMAC_SHA512));
		System.out.println(Salt.verify(password, Salt.createHash(password, HashType.HMAC_SHA512)));
	}
}
