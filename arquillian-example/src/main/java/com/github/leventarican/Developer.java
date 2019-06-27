package com.github.leventarican;

import java.io.PrintStream;

public class Developer {
	public void code(PrintStream to, String language) {
		to.println(editor(language));
	}
	
	public String editor(String language) {
		return "coding in vm: " + language;
	}
}
