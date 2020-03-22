package com.github.leventarican;

import com.github.leventarican.bce.DataControl;
import com.github.leventarican.bce.DataFacade;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/code")
public class Code extends HttpServlet {
    
//    @EJB
//    DataControl data;
    
    @EJB
    DataFacade data;
    
    @Override
    public void init() throws ServletException {
        
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>jee - postgresql</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<p>###</p>");
//            out.println("<code>" + data.getDeveloper() + "</code>");
            out.println("<code>" + data.getData()+ "</code>");
            out.println("<p>###</p>");
                        
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "under development.";
    }

}
