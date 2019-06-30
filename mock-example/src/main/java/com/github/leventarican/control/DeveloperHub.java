package com.github.leventarican.control;

import java.util.Random;

import com.github.leventarican.entity.Developer;

public class DeveloperHub {	
	
	public Developer getDeveloper() {
		Random random = new Random();
		switch (random.nextInt(3)) {
		case 0:
			return new Developer(0L, "java");			
		case 1:
			return new Developer(1L, "kotlin");	
		case 2:
			return new Developer(2L, "cpp");
		default:
			return new Developer(3L, "undefined");
		}
	}
}
