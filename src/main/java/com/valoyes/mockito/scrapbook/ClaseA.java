package com.valoyes.mockito.scrapbook;

public class ClaseA {

	private ClaseB claseB;

	public ClaseA(ClaseB b) {
		this.claseB = b;
	}
	
	public int usesVoidMethod() {
		try {
			claseB.voidMethod();
		} catch (Exception e) {
			new RuntimeException(e);
		}
		return 0;
	}
	
	
}
