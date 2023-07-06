package schonl_ip_l5_web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import schoolOnline.entities.Course;
import schoolOnline.repositories.CloudRepository47;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/webCourseGet", initParams = @WebInitParam(name = "id", value = "0"))

public class WebCourseGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String id = req.getParameter("id");
        if (id == null) {
            id = getInitParameter("id");
        }
        List<Course> courseList = CloudRepository47.getCourseList();
        Course tempCourse = null;
        for(int i = 0; i < courseList.size(); i++) {
            if(Integer.parseInt(id) == courseList.get(i).getId())
            tempCourse = courseList.get(i);
        }
        PrintWriter writer = resp.getWriter();
        if (tempCourse == null){
            writer.println("<h2>Hello choose id.</h2>");
        } else {
            writer.println("<h2>" + tempCourse + "</h2>");
        }
        writer.close();
    }
}

