
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author levent@protonmail.com
 */
public class Foobar extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<code>");
            printWriter.println("code");
            printWriter.println("</code>");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
