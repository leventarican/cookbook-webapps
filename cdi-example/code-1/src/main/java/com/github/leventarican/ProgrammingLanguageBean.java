package com.github.leventarican;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Levent
 */
public class ProgrammingLanguageBean implements ProgrammingLanguageInterface {

    List<String> list = Arrays.asList("java", "kotlin", "cpp", "python", "javascript");
    
    @Override
    public String getProgrammingLanguage() {
        Collections.shuffle(list);
        return list.get(0);
    }

}
