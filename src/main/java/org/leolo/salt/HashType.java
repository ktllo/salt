package org.leolo.salt;

public enum HashType {
	
	MD5("mp"),
	SHA1("s1"),
	SHA256("s2"),
	SHA384("s3"),
	SHA512("s5"),
	HMAC_MD5("mh"),
	HMAC_SHA1("h1"),
	HMAC_SHA256("h2"),
	HMAC_SHA384("h3"),
	HMAC_SHA512("h5");
	
	
	HashType(String id) {
		this.id = id;
	}
	
	/**
	 * A 2 byte algorithm identifier
	 */
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
