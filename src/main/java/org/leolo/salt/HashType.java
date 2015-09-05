package org.leolo.salt;

public enum HashType {
	
	MD5("x4"),
	SHA1("x5");
	
	
	HashType(String id) {
		this.id = id;
	}

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
