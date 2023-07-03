package schonl_ip_l5_web.create;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = "/webAddMatForm")

public class NewAddMatForm  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\"\n" +
                "        content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "<title>New additional material.</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Create new additional material.</h1>\n" +
                "\n" +
                "<form action=\"/process\" method=\"post\">\n" +
                "\n" +
                "\t<label for=\"name\">Type:</label>\n" +
                "\t<input type=\"text\" id=\"name\" name=\"name\" required><br><br>\n" +
                "\n" +
                "\t<label for=\"web\">Source:</label>\n" +
                "\t<input type=\"text\" id=\"web\" name=\"name\" required><br><br>\n" +
                "\n" +
                "\t<input type=\"submit\" value=\"Send\">\n" +
                "</form>");
        out.println("<br/><a href=\"webAddMat\">Back.</a>");
        out.println("<br/><a href=\"webMain\">Return to main.</a>");
        out.println("</body></html>");
        out.close();
    }
}