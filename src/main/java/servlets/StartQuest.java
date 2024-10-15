package servlets;

import entity.Answer;
import entity.Question;
import repository.QuestionRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/start")
public class StartQuest extends HttpServlet {
    public String username;
    public static final int RUSH_SCORE = 0;
    public int MaxRushScore;
    public static final int WHO_SCORE = 0;
    public int MaxWhoScore;
    public static final int WHO_SCORE_BIRD = 0;
    public int MaxWhoScoreBird;


    private QuestionRepository quest=new QuestionRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        if (session.getAttribute("command") == null) {
            session.setAttribute("command", Command.MENU);
            session.setAttribute("score", RUSH_SCORE);
            session.setAttribute("score-max", MaxRushScore);
            session.setAttribute("username", username);
            session.setAttribute("space-end", "не пройден");
            session.setAttribute("who-id",1);
            session.setAttribute("who-q-1","Куница");
            session.setAttribute("who-q-2","Волк");
            session.setAttribute("who-q-3","Лиса");
            session.setAttribute("who-q-4","Пантера");
            session.setAttribute("score-who", WHO_SCORE);
            session.setAttribute("score-who-max", MaxWhoScore);
            session.setAttribute("who-id-bird",1);
            session.setAttribute("who-q-1-bird","Лебедь");
            session.setAttribute("who-q-2-bird","Журавль");
            session.setAttribute("who-q-3-bird","Цапля");
            session.setAttribute("who-q-4-bird","Чайка");
            session.setAttribute("score-who-bird", WHO_SCORE_BIRD);
            session.setAttribute("score-who-max-bird", MaxWhoScoreBird);



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
        int scoreWho=(int) session.getAttribute("score-who");
        int scoreWhoMax=(int) session.getAttribute("score-who-max");



        int id=(int)session.getAttribute("who-id");

        Question question=quest.getQuestAnimal(id);
        Answer quest1=question.getAnswerOne();
        Answer quest2=question.getAnswerTwo();
        Answer quest3=question.getAnswerThree();
        Answer quest4=question.getAnswerFour();




        if(action!=null&&id<12) {
            switch (action) {
                case "menu" -> {score=0;id=1;scoreWho=0; session.setAttribute("command", Command.MENU);session.setAttribute("lose",false);}
                case "game1" -> session.setAttribute("command", Command.START);
                case "start1" -> session.setAttribute("command", Command.SPACE1);
                case "acceptCall" -> session.setAttribute("command", Command.SPACE2);
                case "rejectCall","refuseGoUp","lie" -> session.setAttribute("lose", true);
                case "goUp" -> session.setAttribute("command", Command.SPACE3);
                case "truth" -> {spaceEnd="пройден";session.setAttribute("command", Command.SPACE4);}
                case "game4" -> session.setAttribute("command", Command.JAVA_RUSH);
                case "start4" -> {session.setAttribute("command", Command.QUESTION1);}
                case "quest1_1" -> session.setAttribute("command", Command.QUESTION2);
                case "quest1_2" ->{score++; session.setAttribute("command", Command.QUESTION2);}
                case "quest2_1" -> session.setAttribute("command", Command.QUESTION3);
                case "quest2_2" -> {score++;  session.setAttribute("command", Command.QUESTION3);}
                case "quest3_1" -> session.setAttribute("command", Command.QUESTION4);
                case "quest3_2" -> {score++;  session.setAttribute("command", Command.QUESTION4);}
                case "quest4_1" -> session.setAttribute("command", Command.QUESTION5);
                case "quest4_2" -> {score++;  session.setAttribute("command", Command.QUESTION5);}
                case "quest5_1" -> session.setAttribute("command", Command.QUESTION6);
                case "quest5_2" ->{score++; session.setAttribute("command", Command.QUESTION6);}
                case "quest6_1" -> session.setAttribute("command", Command.QUESTION7);
                case "quest6_2" -> {score++;  session.setAttribute("command", Command.QUESTION7);}
                case "quest7_1" -> session.setAttribute("command", Command.QUESTION8);
                case "quest7_2" -> {score++;  session.setAttribute("command", Command.QUESTION8);}
                case "quest8_1" -> session.setAttribute("command", Command.QUESTION9);
                case "quest8_2" -> {score++;  session.setAttribute("command", Command.QUESTION9);}
                case "quest9_1" -> session.setAttribute("command", Command.QUESTION10);
                case "quest9_2" -> {score++;  session.setAttribute("command", Command.QUESTION10);}
                case "quest10_1" -> session.setAttribute("command", Command.QUESTION11);
                case "quest10_2" -> {score++;  session.setAttribute("command", Command.QUESTION11);}
                case "game2" -> session.setAttribute("command", Command.WHO);

                case "start-who-animal"->{session.setAttribute("command", Command.WHO_Q_A);
                session.setAttribute("who-q-1", "Куница");
                session.setAttribute("who-q-2", "Волк");
                session.setAttribute("who-q-3", "Лиса");
                session.setAttribute("who-q-4", "Пантера");}

                case "who-answer1", "who-answer2", "who-answer3", "who-answer4" -> {
                    session.setAttribute("command", Command.WHO_Q_A);
                    session.setAttribute("who-q-1", quest1.getAnswer());
                    session.setAttribute("who-q-2", quest2.getAnswer());
                    session.setAttribute("who-q-3", quest3.getAnswer());
                    session.setAttribute("who-q-4", quest4.getAnswer());
                    id++;
                }

                case "start-who-bird" -> {session.setAttribute("command", Command.WHO_Q_B);
                    session.setAttribute("who-q-1", "Лебедь");
                    session.setAttribute("who-q-2", "Журавль");
                    session.setAttribute("who-q-3", "Цапля");
                    session.setAttribute("who-q-4", "Чайка");}





            }
        }

        if(action!=null&&id>1&&id<14){
            Question question1=quest.getQuestAnimal(id-2);
            Answer quest11=question1.getAnswerOne();
            Answer quest22=question1.getAnswerTwo();
            Answer quest33=question1.getAnswerThree();
            Answer quest44=question1.getAnswerFour();

            if(action.equals("who-answer1")&&quest11.isRight()) scoreWho++;
            else if(action.equals("who-answer2")&&quest22.isRight()) scoreWho++;
            else if(action.equals("who-answer3")&&quest33.isRight()) scoreWho++;
            else if(action.equals("who-answer4")&&quest44.isRight()) scoreWho++;

        }






        if(username!=null){session.setAttribute("username",username);}
        session.setAttribute("space-end",spaceEnd);
        if(maxScore<score){maxScore=score;}

        if(scoreWhoMax<scoreWho){scoreWhoMax=scoreWho;}
        session.setAttribute("score-max",maxScore);
        session.setAttribute("score",score);
        session.setAttribute("who-id",id);
        session.setAttribute("score-who",scoreWho);
        session.setAttribute("score-who-max",scoreWhoMax);
        if(id>=11&&action!=null){session.setAttribute("command", Command.WHO_END_A);}
        response.sendRedirect("start");
    }

//    private boolean isRightAnswer(String action,Question question){
//        Answer quest1=question.getAnswerOne();
//        Answer quest2=question.getAnswerTwo();
//        Answer quest3=question.getAnswerThree();
//        Answer quest4=question.getAnswerFour();
//    if(action.equals("who-answer1")&&quest1.isRight()){return true;}
//    if(action.equals("who-answer2")&&quest2.isRight()){return true;}
//    if(action.equals("who-answer3")&&quest3.isRight()){return true;}
//    if(action.equals("who-answer4")&&quest4.isRight()){return true;}
//    else return false;
//    }




}
