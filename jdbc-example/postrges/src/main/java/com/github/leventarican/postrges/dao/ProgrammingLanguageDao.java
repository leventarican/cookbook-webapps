package com.github.leventarican.postrges.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Levent
 */
public class ProgrammingLanguageDao implements Dao<ProgrammingLanguage>{
    
    @Override
    public ProgrammingLanguage read(int id) {
        ResultSet result = null;
        
        try (var postgresql = DriverManager.getConnection("jdbc:postgresql://localhost:5432/developer-db", "postgres", "")) {
            result = postgresql.createStatement().executeQuery("select * from programming_languages");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        try {
            while (result.next()) {
                int i = result.getInt(1);
                String n = result.getString(2);
                if (i == id) {
                    ProgrammingLanguage pl = new ProgrammingLanguage();
                    pl.setId(i);
                    pl.setName(n);
                    return pl;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

}
