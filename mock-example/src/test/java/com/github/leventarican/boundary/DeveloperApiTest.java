package com.github.leventarican.boundary;

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
	
	@InjectMocks
	DeveloperApi api;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test() {
		Mockito.when(hub.getDeveloper()).thenReturn(new Developer(0L, "java"));		
		Developer dev = api.getDeveloper();
		System.out.println(dev);
	}

}
