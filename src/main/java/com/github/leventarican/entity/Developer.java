package com.github.leventarican.entity;

import javax.json.bind.JsonbBuilder;

/**
 * with JSON-B
 * 
 * @author levent@protonmail.com
 */
public class Developer {
    Integer id;
    String language;

    public Developer(Integer id, String language) {
        this.id = id;
        this.language = language;
    }

    public Integer getId() {
        return id;
    }
    
    public String toJson() {
        return JsonbBuilder.create().toJson(this);
    }

    @Override
    public String toString() {
        return String.format("[dev] id:%d; language:%s", id, language);
    }
}
