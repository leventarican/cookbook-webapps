package com.github.leventarican.database;

import java.util.ArrayList;
import java.util.List;

/**
 * @author levent@protonmail.com
 */
public class InMemory {
    List<Table> tables = new ArrayList<>();

    @Override
    public String toString() {
        
        for (Table table : tables) {
            
        }
        
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    void generateData() {
        generateDevelopers();
    }
    
    void generateDevelopers() {
        Table developers = new Table();
        for (int i = 0; i < 2; i++) {
            switch (i) {
                case 0: {
                    Row data = new Row();
                    Value<Integer> id = new Value<>(0);
                    Value<String> language = new Value<>("java");
                    data.values.add(id);
                    data.values.add(language);
                    developers.rows.add(data);
                }
                case 1: {
                    Row data = new Row();
                    Value<Integer> id = new Value<>(1);
                    Value<String> language = new Value<>("kotlin");
                    data.values.add(id);
                    data.values.add(language);
                    developers.rows.add(data);
                }
            }
        }
        tables.add(developers);
    }
}

class Table {
    List<Row> rows = new ArrayList<>();
}

class Row {
    List<Value> values = new ArrayList<>();
}

class Value<T> {
    T object;
    Value(T object) {
        this.object = object;
    }
    public T getObject() {
        return this.object;
    }
}
