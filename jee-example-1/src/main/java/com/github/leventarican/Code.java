package com.github.leventarican;

import com.github.leventarican.control.HelloUtil;
import com.github.leventarican.control.MySingleton;
import com.github.leventarican.control.MySingletonBeanManagedConcurrency;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.ejb.EJB;
import javax.inject.Inject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/code")
public class Code extends HttpServlet {

    @EJB
    HelloUtil util;
    
    @Inject
    MySingleton bean;
    
    @Inject
    MySingletonBeanManagedConcurrency bean2;

    @Override
    public void init() throws ServletException {
        util.store("startup", LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try ( PrintWriter out = response.getWriter()) {

//            out.println("<b>ping: " + hello.ping() + "</b>");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Singleton Bean</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Singleton Bean</h1>");
            out.println("<h2>Container-managed Concurrency</h2>");
            out.println(bean.readSomething() + "<br>");
            out.println(bean.writeSomething("Duke") + "<br>");
            out.println("<h2>Bean-managed Concurrency</h2>");
            out.println(bean2.readSomething() + "<br>");
            out.println(bean2.writeSomething("Duke"));
            
            out.println("<b>time: " + util.get("startup") + "</b>");
            out.println("<b>aaa</b>");
            out.println("<b>random: " + util.getRandom() + "</b>");
            out.println("<b>bbb</b>");
            out.println("<b>time2: " + util.get("startup") + "</b>");
            out.println("<b>####</b>");
            
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
