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
    public String username;
    public static final int RUSH_SCORE = 0;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        if (session.getAttribute("command") == null) {
            session.setAttribute("command", Command.MENU);
            session.setAttribute("score", RUSH_SCORE);
            session.setAttribute("username", username);
            session.setAttribute("space-end", false);

        }

        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = request.getParameter("name");
        int score = (int) session.getAttribute("score");
        boolean spaceEnd= (boolean)session.getAttribute("space-end");
        Command command = (Command) session.getAttribute("command");

        if (action != null) {
            switch (action) {
                case "menu" -> {session.setAttribute("command", command.MENU);session.setAttribute("lose",false);}
                case "game1" -> session.setAttribute("command", command.START);
                case "start1" -> session.setAttribute("command", command.SPACE1);
                case "acceptCall" -> session.setAttribute("command", command.SPACE2);
                case "rejectCall","refuseGoUp","lie" -> session.setAttribute("lose", true);
                case "goUp" -> session.setAttribute("command", command.SPACE3);
                case "truth" -> {spaceEnd=true;session.setAttribute("command", command.SPACE4);}
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
        if(username!=null){session.setAttribute("username",username);}
        session.setAttribute("space-end",spaceEnd);
        session.setAttribute("score",score);
        response.sendRedirect("start");
    }



}
