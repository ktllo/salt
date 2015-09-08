package org.leolo.salt;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void testCreateHash() {
		try{
			String p = "password";
			for(HashType ht:HashType.values()){
				Salt.createHash(p, ht);
				String hash1 = Salt.createHash(p, ht);
				String hash2 = Salt.createHash(p, ht);
				switch(ht){
				case MD5:
				case SHA1:
				case SHA256:
				case SHA384:
				case SHA512:
				case BASE16_MD5:
				case BASE16_SHA1:
				case BASE16_SHA256:
				case BASE16_SHA384:
				case BASE16_SHA512:
					break;
				default:
					if(hash1.equals(hash2))
						fail(ht+" EQV");
				}
			}
		}catch(Throwable t){
			t.printStackTrace();
			fail(t.getMessage());
		}
		
	}

	@Test
	public void testVerify() {
		String password = "password";
		String guess = "apssword";
		for(HashType ht:HashType.values()){
			System.out.println(ht);
			String hash = Salt.createHash(password,ht);
			if(!Salt.verify(password, hash))
				fail("Correct password");
			if(Salt.verify(guess, hash))
				fail("Incorrect password");
		}
	}

}
