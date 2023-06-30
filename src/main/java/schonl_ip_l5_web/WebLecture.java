package schonl_ip_l5_web;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import schoolOnline.repositories.CloudRepository47;

@WebServlet(value = "/webLecture")

public class WebLecture extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        CloudRepository47.getLectureList().forEach(lector -> out.println("<h1>" + lector + "</h1>"));
        out.println("<br/><a href=\"webLectureGet\">Get lecture by id.</a>");
        out.println("<br/><a href=\"webMain\">Return to main.</a>");
        out.println("</body></html>");
        out.close();
    }
}