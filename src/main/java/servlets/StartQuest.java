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
    public static final int SCORE = 0;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        if (session.getAttribute("command") == null) {
            session.setAttribute("command", Command.MENU);
            session.setAttribute("score", 0);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        int score = (int) session.getAttribute("score");
        Command command = (Command) session.getAttribute("command");
        if (action != null) {
            switch (action) {
                case "game1" -> session.setAttribute("command", command.START);
                case "start1" -> session.setAttribute("command", command.SPACE1);
                case "acceptCall" -> session.setAttribute("command", command.SPACE2);
                case "rejectCall","refuseGoUp","Lie" -> session.setAttribute("lose", true);
                case "goUp" -> session.setAttribute("command", command.SPACE3);
                case "Truth" -> session.setAttribute("command", command.SPACE4);
                case "game2" -> session.setAttribute("command", command.DONT_PUSH_MENU);
                case "game4" -> session.setAttribute("command", command.JAVA_RUSH);
                case "start4" -> session.setAttribute("command", command.QUESTION1);
                case "quest1_1" -> session.setAttribute("command", command.QUESTION2);
                case "quest1_2" ->{score++; session.setAttribute("command", command.QUESTION2);}
                case "quest2_1" -> session.setAttribute("command", command.QUESTION3);
                case "quest2_2" -> {score++;  session.setAttribute("command", command.QUESTION3);}
                case "quest3_1" -> session.setAttribute("command", command.QUESTION4);
                case "quest3_2" -> {score++;  session.setAttribute("command", command.QUESTION4);}
                case "quest4_1" -> session.setAttribute("command", command.QUESTION5);
                case "quest4_2" -> {score++;  session.setAttribute("command", command.QUESTION5);}



            }
        }
        session.setAttribute("score",score);
        response.sendRedirect("start");
    }

}
