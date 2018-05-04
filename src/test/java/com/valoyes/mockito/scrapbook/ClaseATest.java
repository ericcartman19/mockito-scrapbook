package com.valoyes.mockito.scrapbook;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ClaseATest {

	@Mock
	ClaseB claseB;
	private ClaseA claseA;
	
	public void setup() {
		MockitoAnnotations.initMocks(this);
		claseA = new ClaseA(claseB);
	}
	
	@Test
	public void usesVoidMethod_ShouldCallVoidMethod() throws Exception {
		// para testear void methods, no hace falta utilizar when de manera explicita
		// when
		claseA.usesVoidMethod();
		// then
		verify(claseB).voidMethod();
	}

}
