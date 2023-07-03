package schonl_ip_l5_web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schoolOnline.entities.Lector;
import schoolOnline.repositories.CloudRepository47;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/webLectorGet", initParams = @WebInitParam(name = "id", value = "0"))

public class WebLectorGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String id = req.getParameter("id");
        if (id == null) {
            id = getInitParameter("id");
        }
        List<Lector> lectorList = CloudRepository47.getLectorList();
        Lector tempLector = null;
        for(int i = 0; i < lectorList.size(); i++) {
            if(Integer.parseInt(id) == lectorList.get(i).getLectorId())
                tempLector = lectorList.get(i);
        }
        PrintWriter writer = resp.getWriter();
        if (tempLector == null){
            writer.println("<h2>Hello choose id.</h2>");
        } else {
            writer.println("<h2>" + tempLector + "</h2>");
        }
        writer.println("<br/><a href=\"webLector\">Back.</a>");
        writer.close();
    }
}