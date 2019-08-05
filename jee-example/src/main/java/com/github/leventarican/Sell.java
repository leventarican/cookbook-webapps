package com.github.leventarican;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Netbeans > create > new > Servlet > change url pattern
 * 
 * @author Levent
 */
@WebServlet(name = "Sell", urlPatterns = {"/sell"})
@MultipartConfig(location = "c:\\tmp")
//@MultipartConfig(location = "/tmp")
public class Sell extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        
        Part part = request.getPart("photo");
        OutputStream os = null;
        InputStream is = null;
        try {
            String path = "c:\\tmp\\" + part.getSubmittedFileName();
            File file = new File(path);
            os = new FileOutputStream(file);
            byte[] b = new byte[1024];
            int i = 0;
            is = part.getInputStream();
            while ((i = is.read(b)) != -1) {
                os.write(b, 0, i);
            }
        } catch (IOException e) {
            throw new ServletException(e.getMessage());
        } finally {
            os.close();
            is.close();
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Sell</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<code>Servlet sell at [context path]: " + request.getContextPath() + "</code>");
            
            out.println("</br>file info");
            out.println("</br>content type: " + part.getContentType());
            out.println("</br>size: " + part.getSize() + " bytes");
            out.println("</br>name: " + part.getName());
            out.println("</br>submitted file name: " + part.getSubmittedFileName());
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
