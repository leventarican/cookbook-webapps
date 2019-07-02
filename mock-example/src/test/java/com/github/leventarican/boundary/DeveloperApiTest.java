package com.github.leventarican.boundary;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.github.leventarican.General;
import com.github.leventarican.control.DeveloperHub;
import com.github.leventarican.entity.Developer;

public class DeveloperApiTest {

	@Mock
	DeveloperHub hub;
	
	// inject hub to cut
	@InjectMocks
	DeveloperApi cut;	// code / class under test
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testStep0() {
		// now define the behavior of hub
		Mockito.when(hub.getDeveloper()).thenReturn(new Developer(0L, "java"));
		
		// call
		Developer dev = cut.getDeveloper();
		System.out.println(dev);
	}

	@Test
	public void testStep1() {
		General general = Mockito.mock(General.class);
		Mockito.doReturn(42.0).when(general).getPi();
		
		System.out.println(general.getPi());
		System.out.println(general.getPi());
		
		Mockito.verify(general, Mockito.times(2)).getPi();
	}
	
	
	@Test(expected = ArithmeticException.class)
	public void testStep2() {
		General general = Mockito.mock(General.class);
		Mockito.when(general.divideZero()).thenThrow(new ArithmeticException("i cant divide zero."));
		general.divideZero();
	}
	
}
