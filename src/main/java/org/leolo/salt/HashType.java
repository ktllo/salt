package org.leolo.salt;

/**
 * Identify the hashing algorithm used
 * @author leolo
 *
 */
public enum HashType {
	/**
	 * Plain MD5 hash. This option is considered as insecure
	 */
	MD5("mp"),
	/**
	 * Plain SHA-1 hash. This option is considered as insecure
	 */
	SHA1("s1"),
	/**
	 * Plain SHA-256 hash.
	 */
	SHA256("s2"),
	/**
	 * Plain SHA-384 hash.
	 */
	SHA384("s3"),
	/**
	 * Plain SHA-512 hash.
	 */
	SHA512("s5"),
	/**
	 * Salted MD5 hash.
	 */
	SALTED_MD5("md"),
	/**
	 * Salted SHA-1 hash.
	 */
	SALTED_SHA1("d1"),
	/**
	 * Salted SHA-256 hash.
	 */
	SALTED_SHA256("d2"),
	/**
	 * Salted SHA-384 hash.
	 */
	SALTED_SHA384("d3"),
	/**
	 * Salted SHA-512 hash.
	 */
	SALTED_SHA512("d5"),
	/**
	 * Keyed MD5 hash.
	 */
	HMAC_MD5("mh"),
	/**
	 * Keyed SHA-1 hash.
	 */
	HMAC_SHA1("h1"),
	/**
	 * Keyed SHA-256 hash.
	 */
	HMAC_SHA256("h2"),
	/**
	 * Keyed SHA-384 hash.
	 */
	HMAC_SHA384("h3"),
	/**
	 * Keyed SHA-512 hash.
	 */
	HMAC_SHA512("h5"),
	/**
	 * Plain MD5, encoded in Base16
	 */
	BASE16_MD5("p0"),
	/**
	 * Plain SHA1, encoded in Base16
	 */
	BASE16_SHA1("p1"),
	/**
	 * Plain SHA256, encoded in Base16
	 */
	BASE16_SHA256("p2"),
	/**
	 * Plain SHA384, encoded in Base16
	 */
	BASE16_SHA384("p3"),
	/**
	 * Plain SHA512, encoded in Base16
	 */
	BASE16_SHA512("p4");
	
	
	HashType(String id) {
		this.id = id;
	}
	
	/**
	 * A 2 byte algorithm identifier
	 */
	private String id;

	String getId() {
		return id;
	}

	void setId(String id) {
		this.id = id;
	}
	
	static HashType getType(String id){
		for(HashType ht:HashType.values()){
			if(id.equals(ht.id))
				return ht;
		}
		return null;
	}
}
