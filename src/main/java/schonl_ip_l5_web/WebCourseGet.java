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
        writer.println("<html>\n" +
                "    \n" +
                "    <style>\n" +
                "        * {\n" +
                "            box-sizing: border-box;\n" +
                "        }\n" +
                "\n" +
                "        html,\n" +
                "        body {\n" +
                "            padding: 0;\n" +
                "            margin: 0;\n" +
                "            font-family: Montserrat;\n" +
                "            font-size: 18px;\n" +
                "            font-weight: 500;\n" +
                "        }\n" +
                "\n" +
                "        body {\n" +
                "            color: black;\n" +
                "            font-size: 18px;\n" +
                "            padding: 0;\n" +
                "            display: flex;\n" +
                "            flex-direction: column;\n" +
                "        }\n" +
                "\n" +
                "        main {\n" +
                "            display: flex;\n" +
                "            flex-direction: column;\n" +
                "        }\n" +
                "\n" +
                "        article {\n" +
                "            text-align: center;\n" +
                "            background-color: yellow;\n" +
                "            flex: 2 2 12em;\n" +
                "            padding: 1em;\n" +
                "            font-weight: 600;\n" +
                "            font-size: 18px;\n" +
                "            font-family: montserrat;\n" +
                "        }\n" +
                "\n" +
                "        nav,\n" +
                "        aside {\n" +
                "            flex: 1;\n" +
                "            background-color: deepskyblue;\n" +
                "            text-align: center;\n" +
                "            font-size:64px;\n" +
                "            font-weight: 800;\n" +
                "            color: greenyellow;\n" +
                "        }\n" +
                "\n" +
                "        nav {\n" +
                "            order: -1;\n" +
                "        }\n" +
                "\n" +
                "        header,\n" +
                "        footer {\n" +
                "            color: greenyellow;\n" +
                "            text-align: center;\n" +
                "            background-color: deepskyblue;\n" +
                "            font-size: 56px;\n" +
                "            font-weight: 900;\n" +
                "        }\n" +
                "\n" +
                "        @media screen and (min-width: 600px) {\n" +
                "\n" +
                "            body {\n" +
                "                min-height: 100vh;\n" +
                "            }\n" +
                "\n" +
                "            main {\n" +
                "                flex-direction: row;\n" +
                "                min-height: 100%;\n" +
                "                flex: 1 1 auto;\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "        a:link {\n" +
                "            color: darkblue;\n" +
                "            text-decoration: none\n" +
                "        }\n" +
                "\n" +
                "        a:visited {\n" +
                "            color: blue;\n" +
                "            text-decoration: none\n" +
                "        }\n" +
                "\n" +
                "        a:hover {\n" +
                "            color: cornflowerblue;\n" +
                "            text-decoration: underline\n" +
                "        }\n" +
                "\n" +
                "        a:active {\n" +
                "            color: orange;\n" +
                "            text-decoration: underline\n" +
                "        }\n" +
                "h3:nth-child(odd) {\n" +
                "      background-color: green;\n" +
                "   }\n" +
                "\n" +
                "h3:nth-child(even) {\n" +
                "      background-color: orange;\n" +
                "}\n" +
                "h2{" +
                "color: green;" +
                "}" +
                "</style>\n" +
                "\n" +
                "<body>\n" +
                "<header>\n" +
                "    <p>Welcome to our School Online!</p>\n" +
                "</header>\n" +
                "<main>\n" +
                "    <article>\n");
        if (tempCourse == null){
            writer.println("<h2>Hello choose id.</h2>");
        } else {
            writer.println("<h2>" + tempCourse + "</h2>");
        }
        writer.println("<br/><a href=\"webCourse\">Back.</a>");
        writer.println("\n</article>\n" +
                "\n" +
                "    <nav>\n" +
                "        <p>Start!</p>\n" +
                "    </nav>\n" +
                "    <aside>\n" +
                "        <p>Success!</p>\n" +
                "    </aside>\n" +
                "</main>\n" +
                "<footer>\n" +
                "    <p>Welcome to our School Online!</p>\n" +
                "</footer>\n" +
                "</body>\n" +
                "\n" +
                "</html>");
        writer.close();
    }
}

