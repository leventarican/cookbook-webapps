package com.github.leventarican.database;

import com.github.leventarican.entity.Developer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author levent@protonmail.com
 */
public class InMemory {
    List<Table> tables = new ArrayList<>();

    // kinda JPA
    public Developer getDeveloper(Integer did) {
        for (Table table : tables) {
            for (Row row : table.rows) {
//                id = row.values.stream().filter(v -> ((String) v.getObject()).equals(did)).findAny().orElse(null);
                Value<Integer> id = row.values.get(0);
                if (did.intValue() == id.getObject().intValue()) {
                    Value<String> language = row.values.get(1);
                    return new Developer(id.getObject(), language.getObject());
                }
            }
        }
        return null;
    }
    
    public void generateData() {
        generateDevelopers();
    }
    
    void generateDevelopers() {
        Table developers = new Table();
        for (int i = 0; i < 1; i++) {
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
