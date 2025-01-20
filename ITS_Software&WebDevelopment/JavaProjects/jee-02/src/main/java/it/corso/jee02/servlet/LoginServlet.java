package it.corso.jee02.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getAttribute("loggato") != null) {
            resp.sendRedirect("user");
        } else if (req.getSession().getAttribute("loginadmin") != null) {
            resp.sendRedirect("admin");
        } else {
            req.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ruolo = req.getParameter("ruolo");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String esitoLogin = controlloLogin(ruolo, username, password);
        if (esitoLogin.startsWith("utente")) {
            impostaCookieLogin("loggato",req, resp);
            resp.sendRedirect("user");
        } else if (esitoLogin.startsWith("admin")){
            req.getSession().setAttribute("loginadmin", esitoLogin);
            resp.sendRedirect("admin");
        } else {
            resp.sendRedirect("login?errore");
        }
    }

    private String controlloLogin(String ruolo, String username, String password) {
        if(ruolo.equals("u")){
            if (username.equals("user") && password.equals("user")){

                return "utente@"+username;
            } else {
                return "negato";
            }
        }else {
            if(username.equals("admin") && password.equals("admin")){
                return "admin@"+username;
            } else {
                return "negato";
            }
        }
    }

    private void impostaCookieLogin(String contenuto, HttpServletRequest request , HttpServletResponse response) {
        Cookie cookie = new Cookie("loginutente", contenuto);
        cookie.setMaxAge(3600);
        System.out.println(request.getContextPath());
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
    }
}
