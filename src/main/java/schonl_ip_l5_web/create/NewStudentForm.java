package schonl_ip_l5_web.create;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/webStudentForm")

public class NewStudentForm  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\"\n" +
                "        content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "<title>Hi, new student!</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>New student registration:</h1>\n" +
                "\n" +
                "<form action=\"/process\" method=\"post\">\n" +
                "\n" +
                "\t<label for=\"lastname\">Lastname:</label>\n" +
                "\t<input type=\"text\" id=\"lastname\" name=\"name\" required><br><br>\n" +
                "\n" +
                "\t<label for=\"firstname\">Name:</label>\n" +
                "\t<input type=\"text\" id=\"firstname\" name=\"name\" required><br><br>\n" +
                "\n" +
                "\t<label for=\"age\">Age:</label>\n" +
                "\t<input type=\"number\" id=\"age\" name=\"name\" required><br><br>\n" +
                "\n" +
                "\t<label for=\"phone\">Phone:</label>\n" +
                "\t<input type=\"tel\" id=\"phone\" name=\"name\" required><br><br>\n" +
                "\n" +
                "\t<label for=\"email\">Email:</label>\n" +
                "\t<input type=\"email\" id=\"email\" name=\"email\" required><br><br>\n" +
                "\n" +
                "\t<input type=\"submit\" value=\"Send\">\n" +
                "\n" +
                "</form>\n");
        out.println("<br/><a href=\"webStudent\">Back.</a>");
        out.println("<br/><a href=\"webMain\">Return to main.</a>");
        out.println("</body></html>");
        out.close();
    }
}