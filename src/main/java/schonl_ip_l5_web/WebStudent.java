package schonl_ip_l5_web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schoolOnline.repositories.CloudRepository47;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(value = "/webStudent")

public class WebStudent  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        CloudRepository47.getStudentList("select * from student order by lastname")
                .forEach(student -> out.println("<h1>" + student + "</h1>"));
        out.println("<br/><a href=\"webStudentSort\">Additional info about students.</a>");
        out.println("<br/><a href=\"webStudentForm\">For new student.</a>");
        out.println("<br/><a href=\"webMain\">Return to main.</a>");
        out.println("</body></html>");
        out.close();
    }
}
