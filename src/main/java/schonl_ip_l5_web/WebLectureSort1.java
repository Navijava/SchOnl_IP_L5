package schonl_ip_l5_web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schoolOnline.repositories.CloudRepository47;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/webLectureSort1")
public class WebLectureSort1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        CloudRepository47.getLectureList("select * from lecture\n" +
                "where lecture_date < '2023-01-01'\n" +
                "order by lecture_date asc")
                .forEach(lecture -> out.println("<h2>Lecture \"" + lecture.getLectureName() +
                        "\", additional material number -  " + lecture.getAddMatQuantity() +
                        ", lecture date - " + lecture.getLectureDate() + ".</h2>"));
        out.println("<br/><a href=\"webLecture\">Back.</a>");
        out.println("<br/><a href=\"webMain\">Return to main.</a>");
        out.println("</body></html>");
        out.close();
    }
}
