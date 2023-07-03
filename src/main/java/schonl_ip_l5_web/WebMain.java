package schonl_ip_l5_web;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/webMain")

public class WebMain extends HttpServlet {
    private String message;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        message = "Welcome to Online School!";
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<a href=\"webCourse\">Our courses.</a><br/><br/>");
        out.println("<a href=\"webLector\">Our Lectors.</a><br/><br/>");
        out.println("<a href=\"webLecture\">Our Lectures.</a><br/><br/>");
        out.println("<a href=\"webStudent\">Our Students.</a><br/><br/>");
        out.println("<a href=\"webAddMat\">Our additional material.</a><br/><br/>");
        out.println("</body></html>");
    }

}
