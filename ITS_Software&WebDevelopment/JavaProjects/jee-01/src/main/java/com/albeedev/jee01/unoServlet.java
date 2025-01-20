package com.albeedev.jee01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/uno")
public class unoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomeUtente = req.getParameter("nome");
        nomeUtente = nomeUtente!=null && !nomeUtente.isEmpty() ? nomeUtente : "Sconosciuto";
        req.setAttribute("nome", nomeUtente);

        req.getServletContext().getRequestDispatcher("/WEB-INF/view/uno.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
