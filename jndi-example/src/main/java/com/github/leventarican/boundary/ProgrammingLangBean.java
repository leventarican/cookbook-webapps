package com.github.leventarican.boundary;

import java.util.Random;
import java.util.logging.Logger;

import javax.ejb.Stateless;

@Stateless
public class ProgrammingLangBean implements ProgrammingLangRemoteBI {

	public static final String[] PROGRAMMING_LANGUAGES = {"Java", "Kotlin", "Cpp", "Python", "JavaScript"};
	private Logger log = Logger.getAnonymousLogger();
	
	@Override
	public String randomProgrammingLanguage() {
		Random random = new Random();
		int id = random.nextInt(PROGRAMMING_LANGUAGES.length);
		log.info("id: " + id);
		return PROGRAMMING_LANGUAGES[id];
	}

}
