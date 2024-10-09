package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/start")
public class StartQuest extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        if (session.getAttribute("command") == null) {
            session.setAttribute("command", Command.MENU);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        Command command = (Command) session.getAttribute("command");
        if (action != null) {
            switch (action) {
                case "game1" -> session.setAttribute("command", command.START);
                case "start" -> session.setAttribute("command", command.QUESTION1);
                case "acceptCall" -> session.setAttribute("command", command.QUESTION2);
                case "rejectCall","refuseGoUp","Lie" -> session.setAttribute("dead", true);
                case "goUp" -> session.setAttribute("command", command.QUESTION3);
                case "Truth" -> session.setAttribute("command", command.QUESTION4);
            }
        }
        response.sendRedirect("start");
    }
}