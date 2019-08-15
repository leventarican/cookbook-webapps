package com.github.leventarican.boundary;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.logging.Logger;

import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;

import com.github.leventarican.JNDIProperties;

/**
 * do a JNDI lookup for our EJB {@link ProgrammingLangBean} and call the remote method.
 * <p>test with payara 5. we need the {@code gf-client} dependency.
 * <p>list jndi entries with: {@code asadmin list-jndi-entries --context java:global/jndi-example}
 * 
 * @author Levent
 */
public class ProgrammingLangBeanTest {

	Logger log = Logger.getAnonymousLogger();
	ProgrammingLangRemoteBI but;	// bean under test

	@Before
	public void setUp() throws Exception {
		InitialContext context = new InitialContext(JNDIProperties.getInitProperties());
		// 
		but = (ProgrammingLangRemoteBI) context.lookup("java:global/jndi-example/ProgrammingLangBean!com.github.leventarican.boundary.ProgrammingLangRemoteBI");
	}

	@Test
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
	
	@Test
	public void step2() {
		String randomProgrammingLanguage = but.randomProgrammingLanguage();
		log.info(String.format("EJB: %s", randomProgrammingLanguage));
	}

}
