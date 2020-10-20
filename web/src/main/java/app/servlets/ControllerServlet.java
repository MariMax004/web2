package app.servlets;

import app.model.Model;
import app.pointData.Point;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("")
public class ControllerServlet extends HttpServlet {
    Double parse(String str){
        return Double.parseDouble(str.replace(',','.'));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/main_page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Double x = Double.parseDouble(req.getParameter("X"));
            Double y = Double.parseDouble(req.getParameter("Y"));
            Double r = Double.parseDouble(req.getParameter("InputR"));
            getServletContext().getRequestDispatcher("/areaCheckServlet").forward(req, resp);
        }catch (NumberFormatException | NullPointerException exception ){
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.write(NullEx());
            out.close();
        }catch (Exception e){
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.write(ErrorEx());
            out.close();
        }
    }

    public String ErrorEx(){
        return "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\" />\n" +
                "    <title>Exception_Error</title>\n" +
                "</head>\n" +
                "    <body>\n" +
                "       <style>\n" +
                "            .submit-button{\n" +
                "                margin-top: 20px;\n" +
                "                border-radius: 10px;\n" +
                "                border: 2px solid #FFD700;\n" +
                "                background: #808080;\n" +
                "                font-family: cursive;\n" +
                "                height: 50px;\n" +
                "                width: 150px;\n" +
                "                font-size: 20px;\n" +
                "                cursor: pointer;\n" +
                "                text-decoration: none;\n" +
                "                transition-duration: 0.4s;\n" +
                "            }\n" +
                "            .submit-button:hover, .r-button:hover, .r-button.pressed{\n" +
                "                background: #FFD700;\n" +
                "                color: white;\n" +
                "            }\n" +
                "            body{\n" +
                "                background: #808080;\n" +
                "                min-width: 700px;\n" +
                "                overflow: paged-x;\n" +
                "            }\n" +
                "        </style>" +
                "           <div class=\"head\" >\n" +
                "            <span id=\"head-title\">\n" +
                "                <h1>Молодец, ты поймал Exception, введи новые значения пожалуйста</h1>\n" +
                "            </span>\n" +
                "            <button class=\"submit-button\" onclick=\"location.href='http://localhost:2634/laba_web2_war_exploded/'\">Назад</button>\n" +
                "        </div>\n" +
                "    </body>\n" +
                "</html>";
    }

    public String NullEx(){
        return "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\" />\n" +
                "    <title>Null/Numb_Error</title>\n" +
                "</head>\n" +
                "    <body>\n" +
                "       <style>\n" +
                "            .submit-button{\n" +
                "                margin-top: 20px;\n" +
                "                border-radius: 10px;\n" +
                "                border: 2px solid #FFD700;\n" +
                "                background: #808080;\n" +
                "                font-family: cursive;\n" +
                "                height: 50px;\n" +
                "                width: 150px;\n" +
                "                font-size: 20px;\n" +
                "                cursor: pointer;\n" +
                "                text-decoration: none;\n" +
                "                transition-duration: 0.4s;\n" +
                "            }\n" +
                "            .submit-button:hover, .r-button:hover, .r-button.pressed{\n" +
                "                background: #FFD700;\n" +
                "                color: white;\n" +
                "            }\n" +
                "            body{\n" +
                "                background: #808080;\n" +
                "                min-width: 700px;\n" +
                "                overflow: paged-x;\n" +
                "            }\n" +
                "        </style>" +
                "           <div class=\"head\" >\n" +
                "            <span id=\"head-title\">\n" +
                "                <h1>Молодец, ты поймал NumberFormatException или NullPointerException, введи новые значения пожалуйста</h1>\n" +
                "            </span>\n" +
                "            <button class=\"submit-button\" onclick=\"location.href='http://localhost:2634/laba_web2_war_exploded/'\">Назад</button>\n" +
                "        </div>\n" +
                "    </body>\n" +
                "</html>";
    }
}
