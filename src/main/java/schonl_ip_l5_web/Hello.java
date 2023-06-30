package schonl_ip_l5_web;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/hello")

public class Hello extends HttpServlet {
    private String message;
    public void init() {
        message = "Hello IT World!";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<br/><br/><a href=\"webMain\">About us.</a>");
        out.println("</body></html>");
    }
    public void destroy() {
    }
}
