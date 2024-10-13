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
    public int MaxRushScore;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        if (session.getAttribute("command") == null) {
            session.setAttribute("command", Command.MENU);
            session.setAttribute("score", RUSH_SCORE);
            session.setAttribute("score-max", MaxRushScore);
            session.setAttribute("username", username);
            session.setAttribute("space-end", "не пройден");

        }

        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = request.getParameter("name");
        int score = (int) session.getAttribute("score");
        String spaceEnd= (String) session.getAttribute("space-end");
        int maxScore=(int)session.getAttribute("score-max");

        if (action != null) {
            switch (action) {
                case "menu" -> {score=maxScore; session.setAttribute("command", Command.MENU);session.setAttribute("lose",false);}
                case "game1" -> session.setAttribute("command", Command.START);
                case "start1" -> session.setAttribute("command", Command.SPACE1);
                case "acceptCall" -> session.setAttribute("command", Command.SPACE2);
                case "rejectCall","refuseGoUp","lie" -> session.setAttribute("lose", true);
                case "goUp" -> session.setAttribute("command", Command.SPACE3);
                case "truth" -> {spaceEnd="пройден";session.setAttribute("command", Command.SPACE4);}
                case "game4" -> session.setAttribute("command", Command.JAVA_RUSH);
                case "start4" -> {score=0; session.setAttribute("command", Command.QUESTION1);}
                case "quest1_1" -> session.setAttribute("command", Command.QUESTION2);
                case "quest1_2" ->{score++; session.setAttribute("command", Command.QUESTION2);}
                case "quest2_1" -> session.setAttribute("command", Command.QUESTION3);
                case "quest2_2" -> {score++;  session.setAttribute("command", Command.QUESTION3);}
                case "quest3_1" -> session.setAttribute("command", Command.QUESTION4);
                case "quest3_2" -> {score++;  session.setAttribute("command", Command.QUESTION4);}
                case "quest4_1" -> session.setAttribute("command", Command.QUESTION5);
                case "quest4_2" -> {score++;  session.setAttribute("command", Command.QUESTION5);}
                case "quest5_1" -> session.setAttribute("command", Command.QUESTION2);
                case "quest5_2" ->{score++; session.setAttribute("command", Command.QUESTION6);}
                case "quest6_1" -> session.setAttribute("command", Command.QUESTION3);
                case "quest6_2" -> {score++;  session.setAttribute("command", Command.QUESTION7);}
                case "quest7_1" -> session.setAttribute("command", Command.QUESTION4);
                case "quest7_2" -> {score++;  session.setAttribute("command", Command.QUESTION8);}
                case "quest8_1" -> session.setAttribute("command", Command.QUESTION5);
                case "quest8_2" -> {score++;  session.setAttribute("command", Command.QUESTION9);}
                case "quest9_1" -> session.setAttribute("command", Command.QUESTION4);
                case "quest9_2" -> {score++;  session.setAttribute("command", Command.QUESTION10);}
                case "quest10_1" -> session.setAttribute("command", Command.QUESTION11);
                case "quest10_2" -> {score++;  session.setAttribute("command", Command.QUESTION11);}
            }
        }
        if(username!=null){session.setAttribute("username",username);}
        session.setAttribute("space-end",spaceEnd);
        if(maxScore<score){maxScore=score;}
        session.setAttribute("score-max",maxScore);
        session.setAttribute("score",score);
        response.sendRedirect("start");
    }



}
