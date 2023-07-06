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
        CloudRepository47.getLectureList().forEach(lecture -> out.println("<h1>" + lecture + "</h1>"));
        out.println("<br/><a href=\"webLectureGet\">Get lecture by id.</a>");
        out.println("<br/><a href=\"webLectureSort1\">Get lecture sorted by date.</a>");
        out.println("<br/><a href=\"webLectureSort2\">Get oldest lecture with largest number of homework.</a>");
        out.println("<br/><a href=\"webLectureForm\">New lecture form.</a>");
        out.println("<br/><a href=\"webMain\">Return to main.</a>");
        out.println("</body></html>");
        out.close();
    }
}