//package servlets;
//
//import user.User;
//import user.Users;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet(name = "LoginServlet", value = "/login")
//public class UserLoginServlet extends HttpServlet {
//    Users users;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config);
//        var serverletContext = config.getServletContext();
//        users = (Users) serverletContext.getAttribute("users");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String userName = request.getParameter("uname");
//        User userData;
//        if (userName == null) {
//            userData = (User) request.getSession().getAttribute("userData");
//            if (userData == null) {
//                getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
//                return;
//            }
//        } else {
//            if (userName.isEmpty() || userName.isBlank()) {
//                getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
//                return;
//            }
//            userData = users.getOrCreateUser(userName);
//        }
//        HttpSession currentSession = request.getSession();
//        currentSession.setAttribute("userData", userData);
//        currentSession.setAttribute("usersCount", users.getUserCount());
////        currentSession.setAttribute("question", quest.getQuestion(userData.getCurrentQuest()));
//        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
//    }
//}
