package com.github.leventarican.postrges;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * postgres JDBC connection demonstration.
 * despite the code we need a PostgreSQL JDBC driver.
 * 
 * @author Levent
 */
public class Main {
    
    void postgres() {
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
        System.out.println("postgres.");
        
        var app = new Main();
        app.postgres();
    }
}
