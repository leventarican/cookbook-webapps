package com.github.leventarican;

import com.github.leventarican.control.HelloApi;
import com.github.leventarican.control.HelloUtil;
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

    @EJB
    HelloApi hello;

    @EJB
    HelloUtil util;

    @Override
    public void init() throws ServletException {
        util.store("startup", LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try ( PrintWriter out = response.getWriter()) {
            out.println("<b>time: " + util.get("startup") + "</b>");
            out.println("<b>aaa</b>");
            out.println("<b>random: " + util.getRandom() + "</b>");
            out.println("<b>bbb</b>");
            out.println("<b>ping: " + hello.ping() + "</b>");
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
