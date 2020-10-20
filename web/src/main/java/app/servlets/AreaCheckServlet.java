package app.servlets;


import app.model.Model;
import app.pointData.Point;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/areaCheckServlet")
public class AreaCheckServlet extends HttpServlet {

    void sendAnswer(Point point, HttpServletResponse response) throws IOException {
        String answer = "<head>\n" +
                "    <title>info</title>" +
                "   <meta charset=\"utf-8\" />\n" +
                "    <style>\n" +
                "    body{\n" +
                "    background: #808080;\n" +
                "    min-width: 700px;\n" +
                "    overflow: paged-x;\n" +
                "}table {\n" +
                "    margin-top: 20px;\n" +
                "    width: 100%;\n" +
                "    border-collapse: collapse;\n" +
                "}\n" +
                "thead {\n" +
                "    background: #f5e8d0;\n" +
                "}\n" +
                "td{\n" +
                "    text-align: center;\n" +
                "    padding: 5px;\n" +
                "    width: 10%;\n" +
                "    border: 2px solid #333;\n" +
                "}\n" +
                "tbody tr:nth-child(even) {\n" +
                "    background: #f0f0f0;\n" +
                "}" +
                "  .submit-button{\n" +
                "    margin-top: 20px;\n" +
                "    border-radius: 10px;\n" +
                "    border: 2px solid #FFD700;\n" +
                "    background: #808080;\n" +
                "    font-family: cursive;\n" +
                "    height: 50px;\n" +
                "    width: 150px;\n" +
                "    font-size: 20px;\n" +
                "    cursor: pointer;\n" +
                "    text-decoration: none;\n" +
                "    transition-duration: 0.4s;\n" +
                "}\n" +
                ".submit-button:hover, .r-button:hover, .r-button.pressed{\n" +
                "    background: #FFD700;\n" +
                "    color: white;\n" +
                "}</style>" +
                "</head>\n" +
                "    <body>\n" +
                "        <table class=\"table\">\n" +
                "          <thead>\n" +
                "          <td>X</td>\n" +
                "          <td>Y</td>\n" +
                "          <td>R</td>\n" +
                "          <td>RESULT</td>\n" +
                "          </thead>\n" +
                "          <tbody id=\"table_out\">";

        answer += point.toString();

        answer += "</tbody></table><button class=\"submit-button\" onclick=\"location.href='http://localhost:2634/laba_web2_war_exploded/'\">" +
                "Назад</button></body>";

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(answer);
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession();

        Double x = Double.parseDouble(req.getParameter("X"));
        Double y = Double.parseDouble(req.getParameter("Y"));
        Double r = Double.parseDouble(req.getParameter("InputR"));

        Model model = (Model) session.getAttribute("model");
        if (model == null) {
            model = new Model();
        }
        Point point = new Point();
        point.setR(r);
        point.setX(x);
        point.setY(y);
        point.setRes();
        model.addPoint(point);
        session.setAttribute("model", model);
        sendAnswer(point,resp);
    }
}
