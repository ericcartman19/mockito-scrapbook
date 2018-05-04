package com.valoyes.mockito.scrapbook;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ClaseATest {

	@Mock
	ClaseB claseB;
	private ClaseA claseA;
	
	@Before
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
	
	@Test
	public void usesVoidMethod_ShouldCallVoidMethod_CheckValue() throws Exception {
		// para testear void methods, no hace falta utilizar when de manera explicita
		// assert
		assertSame(1, claseA.usesVoidMethod());
		verify(claseB).voidMethod();
	}
	
	@Test
	public void usesVoidMethod_ExplicitelyStubbing() throws Exception {
		
		// en caso que lo necesitemos podemos decir de forma explicita que nuestro void metodo, haga nada
		doNothing().when(claseB).voidMethod();
		
		assertSame(1, claseA.usesVoidMethod());
		verify(claseB).voidMethod();
	}
	
	@Test
	public void usesVoidMethod_SampleOn_DoThrow() throws Exception {
		
		// when
		doThrow(Exception.class).when(claseB).voidMethod();
		claseA.usesVoidMethod();
	}
	
	

}
