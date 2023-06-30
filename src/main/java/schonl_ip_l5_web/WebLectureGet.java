package schonl_ip_l5_web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schoolOnline.entities.Lecture;
import schoolOnline.repositories.CloudRepository47;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/webLectureGet", initParams = @WebInitParam(name = "id", value = "0"))

public class WebLectureGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String id = req.getParameter("id");
        if (id == null) {
            id = getInitParameter("id");
        }
        List<Lecture> lectureList = CloudRepository47.getLectureList();
        Lecture tempLecture = null;
        for(int i = 0; i < lectureList.size(); i++) {
            if(Integer.parseInt(id) == lectureList.get(i).getId())
                tempLecture = lectureList.get(i);
        }
        PrintWriter writer = resp.getWriter();
        if (tempLecture == null){
            writer.println("<h2>Hello choose id.</h2>");
        } else {
            writer.println("<h2>" + tempLecture + "</h2>");
        }
        writer.close();
    }
}
