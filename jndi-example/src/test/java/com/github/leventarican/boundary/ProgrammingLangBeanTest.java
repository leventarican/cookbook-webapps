package com.github.leventarican.boundary;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.logging.Logger;

public class ProgrammingLangBeanTest {

	Logger log = Logger.getAnonymousLogger();

//	@Test
	public void testRandomProgrammingLanguage() {
		ProgrammingLangBean cut = new ProgrammingLangBean();
		String actual = cut.randomProgrammingLanguage();
		String[] programmingLanguages = ProgrammingLangBean.PROGRAMMING_LANGUAGES;

		for (String programmingLanguage : programmingLanguages) {
			if (programmingLanguage.equals(actual)) {
				log.info(String.format("random programming language: %s", actual));
			}
		}

		boolean result = Arrays.stream(programmingLanguages).anyMatch(actual::equals);
		log.info(String.format("actual value is in the list: %s", result));
		assertTrue(result);
	}
}
