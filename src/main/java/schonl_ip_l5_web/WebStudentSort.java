package schonl_ip_l5_web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schoolOnline.repositories.CloudRepository47;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = "/webStudentSort")

public class WebStudentSort  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        CloudRepository47.getStudentList("select *\n" +
                        "from student\n" +
                        "order by course_quantity asc, lastname asc")
                .forEach(student -> out.println("<h1>" + student.getLastname() + " "
                        + student.getFirstname() + ", number of courses studying at - "
                        + student.getCourseQuantity() + ".</h1>"));
        out.println("<br/><a href=\"webStudent\">Back.</a>");
        out.println("<br/><a href=\"webMain\">Return to main.</a>");
        out.println("</body></html>");
        out.close();
    }
}