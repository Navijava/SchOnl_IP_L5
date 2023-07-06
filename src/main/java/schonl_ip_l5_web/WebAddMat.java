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

                "</style>\n" +
                "\n" +
                "<body>\n" +
                "<header>\n" +
                "    <p>Welcome to our School Online!</p>\n" +
                "</header>\n" +
                "<main>\n" +
                "    <article>\n");
        CloudRepository47.getAddMatInf("select mat_type, count (mat_type) \n" +
                        "from add_mat\n" +
                        "group by mat_type\n" +
                        "order by count")
                .forEach((k, v) -> out.println("<h3>Additional material, type " +
                        k + ", quantity is " + v + ".</h3>"));
        out.println("<br/><a href=\"webAddMatForm\">New additional material form.</a>");
        out.println("<br/><a href=\"webMain\">Return to main.</a>");
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
        out.close();
    }
}