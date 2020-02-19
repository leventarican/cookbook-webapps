package com.github.leventarican.postrges;

import com.github.leventarican.postrges.dao.ProgrammingLanguage;
import com.github.leventarican.postrges.dao.ProgrammingLanguageDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * postgres JDBC connection demonstration.
 * despite the code we need a PostgreSQL JDBC driver.
 * 
 * @author Levent
 */
public class Main {
    
    void postgres() throws Exception {
        var url = "jdbc:postgresql://localhost:5432/developer-db";
        var user = "postgres";
        var password = "";
        try (var connection = DriverManager.getConnection(url, user, password)) {
            var schema = connection.getSchema();
            
            System.out.println("database: developer-db");
            System.out.println("schema: " + schema);
            
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("postgres.");
            
            var app = new Main();
            
            ProgrammingLanguageDao dao = new ProgrammingLanguageDao();
            ProgrammingLanguage pl = dao.read(1);
            
            System.out.println("found: " + pl);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
