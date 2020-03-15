package com.github.leventarican;

import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * @author Levent
 */
public class App {

    public static void main(String[] args) {
        try (var container = SeContainerInitializer.newInstance().initialize()) {
            var programmingLanguageBean = container.select(ProgrammingLanguageBean.class).get();
            System.out.println("\t# code-1: decorators - " + programmingLanguageBean.getProgrammingLanguage());
        }
    }
}
