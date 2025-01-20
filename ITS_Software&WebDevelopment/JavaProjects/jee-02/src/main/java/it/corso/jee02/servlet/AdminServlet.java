package it.corso.jee02.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("out") != null) {
            req.getSession().removeAttribute("loginadmin");
            resp.sendRedirect(req.getContextPath());
            return;
        }

        if(req.getSession().getAttribute("loginadmin") == null) {
            resp.sendRedirect("login");
        }else {
            req.getServletContext().getRequestDispatcher("/WEB-INF/view/admin.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
