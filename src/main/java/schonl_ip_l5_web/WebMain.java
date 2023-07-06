package schonl_ip_l5_web;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/webMain")

public class WebMain extends HttpServlet {
    private String message;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        message = "Welcome to Online School!";
        PrintWriter out = response.getWriter();
        out.println("<html>\n" +
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
                ".greeting h1 {" +
                "color: green" +
                "}" +
                "</style>\n" +
                "\n" +
                "<body>\n" +
                "<header>\n" +
                "    <p>Welcome to our School Online!</p>\n" +
                "</header>\n" +
                "<main>\n" +
                "    <article>\n");
        out.println("<div class = \"greeting\"><h1>" + message + "</h1></div>");
        out.println("<a href=\"webCourse\">Our courses.</a><br/><br/>");
        out.println("<a href=\"webLector\">Our Lectors.</a><br/><br/>");
        out.println("<a href=\"webLecture\">Our Lectures.</a><br/><br/>");
        out.println("<a href=\"webStudent\">Our Students.</a><br/><br/>");
        out.println("<a href=\"webAddMat\">Our additional material.</a><br/><br/>");
        out.println("\n</article>\n" +
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
    }

}
