package com.github.leventarican;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DatabaseConnection
 * http://localhost:8080/jee-example/DatabaseConnection
 * 
 * @author Levent
 */
@WebServlet("/DatabaseConnection")
public class DatabaseConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	option 0: lookup
//	private DataSource ds;
	
//	option 1: injection
	@Resource(name="jdbc/__default") 
	private DataSource ds;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final PrintWriter writer = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		writer.println("<!DOCTYPE html>");
		writer.println("<html><body>");
		try {
//			option 0: lookup
//			ds = InitialContext.doLookup("jdbc/__default");
			Connection con = ds.getConnection();
			if (con.isValid(10)) {
				writer.println("<br>connected");
				
				Statement stmt = con.createStatement();
				ResultSet result = stmt.executeQuery("select * from dev");
				while (result.next()) {
					int id = result.getInt("id");
					String name = result.getString("name");
					String programmingLanguage = result.getString("programming_language");
					writer.println("<br>id: " + id);
					writer.println("<br>name: " + name);
					writer.println("<br>programming_language: " + programmingLanguage);
				}
				
			}
			con.close();
		} catch (Exception e) {
			writer.println(e.getMessage());
		}
		writer.println("<br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
