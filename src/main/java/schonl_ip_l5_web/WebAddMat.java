package schonl_ip_l5_web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schoolOnline.repositories.CloudRepository47;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/webAddMat")
public class WebAddMat extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        CloudRepository47.getAddMatInf("select mat_type, count (mat_type) \n" +
                        "from add_mat\n" +
                        "group by mat_type\n" +
                        "order by count")
                .forEach((k, v) -> out.println("<h2>Additional material, type " +
                        k + ", quantity is " + v + ".</h2>"));
        out.println("<br/><a href=\"webAddMatForm\">New additional material form.</a>");
        out.println("<br/><a href=\"webMain\">Return to main.</a>");
        out.println("</body></html>");
        out.close();
    }
}