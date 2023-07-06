package schonl_ip_l5_web.create;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/webCourseForm")

public class NewCourseForm  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>New course.</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>New course creation:</h1>\n" +
                "\n" +
                "<form action=\"/process\" method=\"post\">\n" +
                "\n" +
                "    <label for=\"courseName\">Course name:</label>\n" +
                "    <input type=\"text\" id=\"courseName\" name=\"name\" required><br><br>\n" +
                "\n" +
                "    <label for=\"lecture\">Number of lectures:</label>\n" +
                "    <input type=\"number\" id=\"lecture\" name=\"name\" required><br><br>\n" +
                "\n" +
                "    <label for=\"student\">Number of students:</label>\n" +
                "    <input type=\"number\" id=\"student\" name=\"name\" required><br><br>\n" +
                "\n" +
                "    <input type=\"submit\" value=\"Send\">\n" +
                "\n" +
                "</form>");
        out.println("<br/><a href=\"webCourse\">Back.</a>");
        out.println("<br/><a href=\"webMain\">Return to main.</a>");
        out.println("</body></html>");
        out.close();
    }
}