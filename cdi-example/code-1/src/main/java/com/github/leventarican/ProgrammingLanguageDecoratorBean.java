package com.github.leventarican;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 * @author Levent
 */
@Decorator
public abstract class ProgrammingLanguageDecoratorBean implements ProgrammingLanguageInterface {

    @Inject
    @Delegate
    private ProgrammingLanguageInterface programmingLanguageInterface;

    @Override
    public String getProgrammingLanguage() {
        return "# Decorator: " + programmingLanguageInterface.getProgrammingLanguage() + " - time: " + DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(LocalDateTime.now());
    }

}
