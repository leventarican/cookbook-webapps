package com.github.leventarican.boundary;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
		
		// test
		Developer dev = cut.getDeveloper();
		String expected = "java";
		String actual = dev.getProgrammingLanguage();
		assertEquals(expected, actual);
	}
	
}
