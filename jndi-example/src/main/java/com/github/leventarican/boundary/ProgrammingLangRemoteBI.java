package com.github.leventarican.boundary;

import javax.ejb.Remote;

/**
 * Remote Business Interface
 * @author Levent
 */
@Remote
public interface ProgrammingLangRemoteBI {
	public abstract String randomProgrammingLanguage();
}
