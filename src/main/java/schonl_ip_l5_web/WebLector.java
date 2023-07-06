package schonl_ip_l5_web;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import schoolOnline.repositories.CloudRepository47;

@WebServlet(value = "/webLector")

public class WebLector extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        CloudRepository47.getLectorList().forEach(lector -> out.println("<h1>" + lector + "</h1>"));
        out.println("<br/><a href=\"webLectorGet\">Get lector by id.</a>");
        out.println("<br/><a href=\"webLectorSort\">Get lector after sort.</a>");
        out.println("<br/><a href=\"webLectorForm\">New lector form.</a>");
        out.println("<br/><a href=\"webMain\">Return to main.</a>");
        out.println("</body></html>");
        out.close();
    }
}