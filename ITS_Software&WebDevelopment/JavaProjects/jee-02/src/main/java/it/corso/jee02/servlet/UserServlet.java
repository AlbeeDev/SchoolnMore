package it.corso.jee02.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("out") != null) {
            logoutUtente(req, resp);
            resp.sendRedirect(req.getContextPath());
            return;
        }
        if(req.getAttribute("loggato") == null) {
            resp.sendRedirect("login");
        }
        else {
            req.getServletContext().getRequestDispatcher("/WEB-INF/view/user.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void logoutUtente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginutente")) {
                cookie.setMaxAge(0);
                cookie.setPath(req.getContextPath());
                resp.addCookie(cookie);
            }
        }
    }
}
