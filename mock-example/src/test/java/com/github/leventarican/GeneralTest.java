package com.github.leventarican;

import org.junit.Test;
import org.mockito.Mockito;

public class GeneralTest {

	@Test
	public void testStep0() {
		General general = Mockito.mock(General.class);
		Mockito.doReturn(42.0).when(general).getPi();
		
		System.out.println(general.getPi());
		System.out.println(general.getPi());
		
		Mockito.verify(general, Mockito.times(2)).getPi();
	}
	
	
	@Test(expected = ArithmeticException.class)
	public void testStep1() {
		General general = Mockito.mock(General.class);
		Mockito.when(general.divideZero()).thenThrow(new ArithmeticException("i cant divide zero."));
		general.divideZero();
	}
}
