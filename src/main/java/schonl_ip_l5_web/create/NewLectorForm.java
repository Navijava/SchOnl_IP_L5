package schonl_ip_l5_web.create;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/webLectorForm")

public class NewLectorForm  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Welcome, lector.</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>New lector:</h1>\n" +
                "\n" +
                "<form action=\"/process\" method=\"post\">\n" +
                "\n" +
                "    <label for=\"lastname\">Lastname:</label>\n" +
                "    <input type=\"text\" id=\"lastname\" name=\"name\" required><br><br>\n" +
                "\n" +
                "    <label for=\"firstname\">Name:</label>\n" +
                "    <input type=\"text\" id=\"firstname\" name=\"name\" required><br><br>\n" +
                "\n" +
                "    <label for=\"courseName\">Course:</label>\n" +
                "    <input type=\"text\" id=\"courseName\" name=\"name\" required><br><br>\n" +
                "\n" +
                "    <label for=\"phone\">Phone:</label>\n" +
                "    <input type=\"tel\" id=\"phone\" name=\"name\" required><br><br>\n" +
                "\n" +
                "    <label for=\"email\">Email:</label>\n" +
                "    <input type=\"email\" id=\"email\" name=\"email\" required><br><br>\n" +
                "\n" +
                "    <input type=\"submit\" value=\"Send\">\n" +
                "\n" +
                "</form>");
        out.println("<br/><a href=\"webLector\">Back.</a>");
        out.println("<br/><a href=\"webMain\">Return to main.</a>");
        out.println("</body></html>");
        out.close();
    }
}