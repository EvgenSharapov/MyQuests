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

@WebServlet("/start")
public class StartServlet extends HttpServlet {
    private String username;
    private static final int RUSH_SCORE = 0;
    private int MaxRushScore;
    private static final int WHO_SCORE = 0;
    private int MaxWhoScore;
    private static final int WHO_SCORE_BIRD = 0;
    private int MaxWhoScoreBird;


    private final QuestionRepository quest=new QuestionRepository();

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
        MaxRushScore=(int)session.getAttribute("score-max");
        int scoreWho=(int) session.getAttribute("score-who");
        MaxWhoScore=(int) session.getAttribute("score-who-max");
        int scoreWhoBird=(int) session.getAttribute("score-who-bird");
        MaxWhoScoreBird=(int) session.getAttribute("score-who-max-bird");


        int id=(int)session.getAttribute("who-id");
        int idBird=(int)session.getAttribute("who-id-bird");

        if(id<12&&idBird<12){

        Question question=quest.getQuestAnimal(id);
        Answer quest1=question.getAnswerOne();
        Answer quest2=question.getAnswerTwo();
        Answer quest3=question.getAnswerThree();
        Answer quest4=question.getAnswerFour();
        Question questionBird=quest.getQuestBird(idBird);
        Answer questBird1=questionBird.getAnswerOne();
        Answer questBird2=questionBird.getAnswerTwo();
        Answer questBird3=questionBird.getAnswerThree();
        Answer questBird4=questionBird.getAnswerFour();




        if(action!=null) {
            switch (action) {
                case "menu" -> {
                    score = 0;
                    id = 1;
                    scoreWho = 0;
                    idBird=1;
                    scoreWhoBird=0;
                    session.setAttribute("command", Command.MENU);
                    session.setAttribute("lose", false);
                }
                case "game1" -> session.setAttribute("command", Command.START);
                case "start1" -> session.setAttribute("command", Command.SPACE1);
                case "acceptCall" -> session.setAttribute("command", Command.SPACE2);
                case "rejectCall", "refuseGoUp", "lie" -> session.setAttribute("lose", true);
                case "goUp" -> session.setAttribute("command", Command.SPACE3);
                case "truth" -> {
                    spaceEnd = "пройден";
                    session.setAttribute("command", Command.SPACE4);
                }
                case "game4" -> session.setAttribute("command", Command.JAVA_RUSH);
                case "start4" -> {
                    session.setAttribute("command", Command.QUESTION1);
                }
                case "quest1_1" -> session.setAttribute("command", Command.QUESTION2);
                case "quest1_2" -> {
                    score++;
                    session.setAttribute("command", Command.QUESTION2);
                }
                case "quest2_1" -> session.setAttribute("command", Command.QUESTION3);
                case "quest2_2" -> {
                    score++;
                    session.setAttribute("command", Command.QUESTION3);
                }
                case "quest3_1" -> session.setAttribute("command", Command.QUESTION4);
                case "quest3_2" -> {
                    score++;
                    session.setAttribute("command", Command.QUESTION4);
                }
                case "quest4_1" -> session.setAttribute("command", Command.QUESTION5);
                case "quest4_2" -> {
                    score++;
                    session.setAttribute("command", Command.QUESTION5);
                }
                case "quest5_1" -> session.setAttribute("command", Command.QUESTION6);
                case "quest5_2" -> {
                    score++;
                    session.setAttribute("command", Command.QUESTION6);
                }
                case "quest6_1" -> session.setAttribute("command", Command.QUESTION7);
                case "quest6_2" -> {
                    score++;
                    session.setAttribute("command", Command.QUESTION7);
                }
                case "quest7_1" -> session.setAttribute("command", Command.QUESTION8);
                case "quest7_2" -> {
                    score++;
                    session.setAttribute("command", Command.QUESTION8);
                }
                case "quest8_1" -> session.setAttribute("command", Command.QUESTION9);
                case "quest8_2" -> {
                    score++;
                    session.setAttribute("command", Command.QUESTION9);
                }
                case "quest9_1" -> session.setAttribute("command", Command.QUESTION10);
                case "quest9_2" -> {
                    score++;
                    session.setAttribute("command", Command.QUESTION10);
                }
                case "quest10_1" -> session.setAttribute("command", Command.QUESTION11);
                case "quest10_2" -> {
                    score++;
                    session.setAttribute("command", Command.QUESTION11);
                }
                case "game2" -> session.setAttribute("command", Command.WHO);

                case "start-who-animal" -> {
                    session.setAttribute("command", Command.WHO_Q_A);
                    session.setAttribute("who-q-1", "Куница");
                    session.setAttribute("who-q-2", "Волк");
                    session.setAttribute("who-q-3", "Лиса");
                    session.setAttribute("who-q-4", "Пантера");
                }

                case "who-answer1", "who-answer2", "who-answer3", "who-answer4" -> {
                    session.setAttribute("command", Command.WHO_Q_A);
                    session.setAttribute("who-q-1", quest1.getAnswer());
                    session.setAttribute("who-q-2", quest2.getAnswer());
                    session.setAttribute("who-q-3", quest3.getAnswer());
                    session.setAttribute("who-q-4", quest4.getAnswer());
                    id++;
                }

                case "start-who-bird" -> {
                    session.setAttribute("command", Command.WHO_Q_B);
                    session.setAttribute("who-q-1-bird", "Лебедь");
                    session.setAttribute("who-q-2-bird", "Журавль");
                    session.setAttribute("who-q-3-bird", "Цапля");
                    session.setAttribute("who-q-4-bird", "Чайка");
                }
                case "who-answer1-bird", "who-answer2-bird", "who-answer3-bird", "who-answer4-bird" -> {
                    session.setAttribute("command", Command.WHO_Q_B);
                    session.setAttribute("who-q-1-bird", questBird1.getAnswer());
                    session.setAttribute("who-q-2-bird", questBird2.getAnswer());
                    session.setAttribute("who-q-3-bird", questBird3.getAnswer());
                    session.setAttribute("who-q-4-bird", questBird4.getAnswer());
                    idBird++;
                }

            }

            }
        }

        if(action!=null&&id>1&&id<14){
            Question question=quest.getQuestAnimal(id-2);
            Answer quest1=question.getAnswerOne();
            Answer quest2=question.getAnswerTwo();
            Answer quest3=question.getAnswerThree();
            Answer quest4=question.getAnswerFour();

            if(action.equals("who-answer1")&&quest1.isRight()) scoreWho++;
            else if(action.equals("who-answer2")&&quest2.isRight()) scoreWho++;
            else if(action.equals("who-answer3")&&quest3.isRight()) scoreWho++;
            else if(action.equals("who-answer4")&&quest4.isRight()) scoreWho++;

        }
        if(action!=null&&idBird>1&&idBird<14){
            Question question=quest.getQuestBird(idBird-2);
            Answer quest1=question.getAnswerOne();
            Answer quest2=question.getAnswerTwo();
            Answer quest3=question.getAnswerThree();
            Answer quest4=question.getAnswerFour();

            if(action.equals("who-answer1-bird")&&quest1.isRight()) scoreWhoBird++;
            else if(action.equals("who-answer2-bird")&&quest2.isRight()) scoreWhoBird++;
            else if(action.equals("who-answer3-bird")&&quest3.isRight()) scoreWhoBird++;
            else if(action.equals("who-answer4-bird")&&quest4.isRight()) scoreWhoBird++;

        }





        if(username!=null){session.setAttribute("username",username);}
        session.setAttribute("space-end",spaceEnd);
        if(MaxRushScore<score){MaxRushScore=score;}

        if(MaxWhoScore<scoreWho){MaxWhoScore=scoreWho;}
        if(MaxWhoScoreBird<scoreWhoBird){MaxWhoScoreBird=scoreWhoBird;}
        session.setAttribute("score-max",MaxRushScore);
        session.setAttribute("score",score);
        session.setAttribute("who-id",id);
        session.setAttribute("score-who",scoreWho);
        session.setAttribute("score-who-max",MaxWhoScore);
        session.setAttribute("who-id-bird",idBird);
        session.setAttribute("score-who-bird",scoreWhoBird);
        session.setAttribute("score-who-max-bird",MaxWhoScoreBird);

        if(id>=11&&action!=null){session.setAttribute("command", Command.WHO_END_A);}
        if(idBird>=11&&action!=null){session.setAttribute("command", Command.WHO_END_B);}
        response.sendRedirect("start");
    }






}
