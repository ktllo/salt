package org.leolo.salt;

public class Test {
	public static void main(String [] args){
		for(int i=0;i<50;i++){
			System.out.println(SaltGenerator.getInstance().getSalt(79));
		}
	}
}
