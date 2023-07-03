package schonl_ip_l5_web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schoolOnline.repositories.CloudRepository47;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/webLectorSort")
public class WebLectorSort extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        CloudRepository47.getLectorList("select *\n" +
                        "from lector\n" +
                        "where lastname >='a' and lastname < 'n'\n" +
                        "or lastname >='а' and lastname < 'н'\n" +
                        "order by lastname")
                .forEach(lector -> out.println("<h2>Lector " + lector.getLastname() +
                        " " + lector.getName() + ".</h2>"));
        out.println("<br/><a href=\"webLector\">Back.</a>");
        out.println("<br/><a href=\"webMain\">Return to main.</a>");
        out.println("</body></html>");
        out.close();
    }
}